package net.thevpc.gaming.atom.examples.kombla.main.client.dal;

import net.thevpc.gaming.atom.examples.kombla.main.server.dal.ServerRmiApi;
import net.thevpc.gaming.atom.examples.kombla.main.shared.engine.AppConfig;
import net.thevpc.gaming.atom.examples.kombla.main.shared.model.DynamicGameModel;
import net.thevpc.gaming.atom.examples.kombla.main.shared.model.StartGameInfo;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class ClientRmiDAO implements MainClientDAO{
    private AppConfig appConfig;
    private Socket socket;
    private DataInputStream in;
    private DataOutputStream out;
    private MainClientDAOListener listener;
    private String serverAddress;
    private int serverPort;

    @Override
    public void start(MainClientDAOListener listener, AppConfig properties) {
        try {
            this.listener = listener;
            this.appConfig=properties;

            String playerName=appConfig.getPlayerName();

            Registry registry = LocateRegistry.getRegistry("localhost", 1234);
            ServerRmiApi serveur = (ServerRmiApi) registry.lookup("RmiApiServeur");
            RmiClientImpl client;
            serveur.setClient( client = new RmiClientImpl(listener));
            StartGameInfo startGameInfo = (StartGameInfo) registry.lookup("StartGameInfo");

            int playerId = startGameInfo.getPlayerId();
            int[][] maze = startGameInfo.getMaze();


            // Log or use these values
            System.out.println("Player ID: " + playerId);
            System.out.println("Maze: " + maze);
            DynamicGameModel dynamicGameModel = (DynamicGameModel) registry.lookup("DynamicGameModel");

            // Access the model's data directly
            System.out.println("Current Frame: " + dynamicGameModel.getFrame());
            System.out.println("Players: " );
            System.out.println("Sprites: " );

            DynamicGameModel gameModel = new DynamicGameModel(dynamicGameModel.getFrame(),dynamicGameModel.getSprites(),dynamicGameModel.getPlayers());

            listener.onModelChanged(gameModel);
        } catch (Exception ex) {
            ex.printStackTrace();
            //ignore error
        }
    }

    @Override
    public StartGameInfo connect() {
        return null;
    }

    @Override
    public void sendMoveLeft() throws IOException {

    }

    @Override
    public void sendMoveRight() throws IOException {

    }

    @Override
    public void sendMoveUp() throws IOException {

    }

    @Override
    public void sendMoveDown() throws IOException {

    }

    @Override
    public void sendFire() throws IOException {

    }
}
