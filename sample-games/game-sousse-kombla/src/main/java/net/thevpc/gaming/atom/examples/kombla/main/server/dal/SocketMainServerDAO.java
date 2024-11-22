package net.thevpc.gaming.atom.examples.kombla.main.server.dal;

import net.thevpc.gaming.atom.examples.kombla.main.client.dal.MainClientDAO;
import net.thevpc.gaming.atom.examples.kombla.main.client.dal.MainClientDAOListener;
import net.thevpc.gaming.atom.examples.kombla.main.shared.dal.ProtocolConstants;
import net.thevpc.gaming.atom.examples.kombla.main.shared.engine.AppConfig;
import net.thevpc.gaming.atom.examples.kombla.main.shared.engine.tasks.BombSpriteMainTask;
import net.thevpc.gaming.atom.examples.kombla.main.shared.model.DynamicGameModel;
import net.thevpc.gaming.atom.examples.kombla.main.shared.model.StartGameInfo;
import net.thevpc.gaming.atom.model.ModelPoint;
import net.thevpc.gaming.atom.model.Player;
import net.thevpc.gaming.atom.model.Sprite;
import net.thevpc.gaming.atom.presentation.TemporalScoreBoard;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.ClientInfoStatus;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SocketMainServerDAO implements MainServerDAO {
    private List<ClientSession> clientSession = new ArrayList<>();
    private final Map<Integer, ClientSession> playerToSocketMap = new HashMap<>();
    private static final int PORT = 1234;
    private int port;
    private StartGameInfo startGameInfo;
    private ServerSocket serverSocket;
    private boolean running = true;
    private String serverAddress;
    private Socket client;
    private DataInputStream in;
    private DataOutputStream out;
    private MainServerDAOListener listener;
@Override
    public void start(MainServerDAOListener listener, AppConfig properties) {
        this.listener = listener;
        int port = properties.getServerPort();
        try {
            serverSocket = new ServerSocket(port);
            System.out.println("Server started on port " + port);

            new Thread(() -> {
                while (true) {
                    try {
                        Socket clientSocket = serverSocket.accept();
                        System.out.println("New client connected: " + clientSocket);

                        ClientSession session = new ClientSession(-2,clientSocket);

                        // Traiter les commandes du client dans un nouveau thread
                        new Thread(() -> processClient(session)).start();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        } catch (IOException e) {
            throw new RuntimeException("Failed to start server", e);
        }
    }
    public void processClient(ClientSession clientSession) {
        try {

            while (true) {

                int command = clientSession.in.readInt();

                switch (command) {
                    case ProtocolConstants.CONNECT:
                        String playerName = clientSession.in.readUTF();
                        StartGameInfo startGameInfo = listener.onReceivePlayerJoined(playerName);
                        clientSession.playerId = startGameInfo.getPlayerId();
                        playerToSocketMap.put(clientSession.playerId, clientSession);
                        writeStartGameInfo(clientSession, startGameInfo);
                        break;
                    case ProtocolConstants.LEFT:
                        listener.onReceiveMoveLeft(clientSession.playerId);
                        break;
                    case ProtocolConstants.RIGHT:
                        listener.onReceiveMoveRight(clientSession.playerId);
                        break;
                    case ProtocolConstants.UP:
                        listener.onReceiveMoveUp(clientSession.playerId);
                        break;
                    case ProtocolConstants.DOWN:
                        listener.onReceiveMoveDown(clientSession.playerId);
                        break;
                    case ProtocolConstants.FIRE:
                        listener.onReceiveReleaseBomb(clientSession.playerId);
                        break;
                    default:
                        System.out.println("Commande inconnue: " + command);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();

        }
        clientSession.close();
    }

    private void writeStartGameInfo(ClientSession clientSession, StartGameInfo startGameInfo) throws IOException {
        try (ByteArrayOutputStream byteStream = new ByteArrayOutputStream();
             ObjectOutputStream objectStream = new ObjectOutputStream(byteStream)) {

            objectStream.writeObject(startGameInfo);
            objectStream.flush();
            byte[] byteArray = byteStream.toByteArray();

            clientSession.out.writeInt(byteArray.length);
            clientSession.out.write(byteArray);
            clientSession.out.flush();
        } catch (IOException e) {
            Logger.getLogger(SocketMainServerDAO.class.getName()).log(Level.SEVERE, "Error ", e);
            throw e;
        }
    }


    public StartGameInfo connect(ClientSession clientSession) {
            String playerName = null;
            try {

                playerName = in.readUTF();

                int playerId = clientSession.playerId;

                playerToSocketMap.put(playerId, clientSession);
                // Étape 3 : Créer une instance de StartGameInfo
                int[][] maze = new int[10][10];
                StartGameInfo startGameInfo = new StartGameInfo(playerId, maze);

                writeStartGameInfo(clientSession, startGameInfo);

                return startGameInfo;

            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }

    private DynamicGameModel currentGameModel;
    public DynamicGameModel getCurrentGameModel() {
        if (currentGameModel == null) {
            currentGameModel = new DynamicGameModel();
        }
        return currentGameModel;
    }



 

    private class ClientSession  {

        private int playerId;
        private Socket socket;
        private DataInputStream in;
        private DataOutputStream out;

        public ClientSession(int playerId, Socket socket) throws IOException {
            this.playerId = playerId;
            this.socket = socket;
            this.in = new DataInputStream(socket.getInputStream());
            this.out = new DataOutputStream(socket.getOutputStream());
        }

        public void close() {
            try {
                if (in != null) in.close();
                if (out != null) out.close();
                if (socket != null) socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

//        public void sendModel(DynamicGameModel model) {
//            try {
//                out.writeInt((int) model.getFrame());
//                out.flush();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
    
   @Override
    public void sendModelChanged(DynamicGameModel dynamicGameModel) {
    for (ClientSession session : playerToSocketMap.values()) {
        try {
            session.out.writeLong(dynamicGameModel.getFrame());

            List<Player> players = dynamicGameModel.getPlayers();
            session.out.writeInt(players.size());
            for (Player player : players) {
                writePlayer(session,player);

            }

            List<Sprite> sprites = dynamicGameModel.getSprites();
            session.out.writeInt(sprites.size());
            for (Sprite sprite : sprites) {
                writeSprite(session, sprite);
            }

            session.out.flush();

        } catch (IOException e) {
            e.printStackTrace();
            session.close();
            playerToSocketMap.remove(session.playerId);
        }
    }
    }

    private void writeSprite(ClientSession clientSession, Sprite sprite) throws IOException {
        try {
            clientSession.out.writeInt(sprite.getId());
            String kind = sprite.getKind();

            clientSession.out.writeUTF(kind);

            String name = sprite.getName();
            clientSession.out.writeUTF(name);

            // Envoi de la direction du sprite
            ModelPoint location = sprite.getLocation();
            out.writeDouble(location.getX());
            out.writeDouble(location.getY());
            out.writeDouble(location.getZ());

            out.writeDouble(sprite.getDirection());

            clientSession.out.writeInt(sprite.getPlayerId());

            // (c) Envoi des propriétés du sprite
            Map<String, Object> properties = sprite.getProperties();
            clientSession.out.writeInt(properties.size());


            for (Map.Entry<String, Object> entry : properties.entrySet()) {
                String key = entry.getKey();
                String value = (String) entry.getValue();


                out.writeUTF(key);
                out.writeUTF(value);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private void writePlayer(ClientSession clientSession, Player player) throws IOException {
        try {
            // (a) Envoi de l'ID du joueur
            clientSession.out.writeInt(player.getId());

            // Envoi du nom du joueur
            String playerName = player.getName();

            // (b) Envoi des propriétés du joueur
            Map<String, Object> properties = player.getProperties();
            clientSession.out.writeInt(properties.size());
            // Envoi de chaque paire clé/valeur dans la Map
            for (Map.Entry<String, Object> entry : properties.entrySet()) {
                String key = entry.getKey();
                String value = entry.getValue().toString();


                clientSession.out.writeUTF(key);
                clientSession.out.writeUTF(value);

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



}
