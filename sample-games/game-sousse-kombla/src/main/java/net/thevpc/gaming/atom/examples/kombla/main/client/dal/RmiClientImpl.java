package net.thevpc.gaming.atom.examples.kombla.main.client.dal;

import net.thevpc.gaming.atom.examples.kombla.main.shared.model.DynamicGameModel;
import net.thevpc.gaming.atom.examples.kombla.main.shared.model.StartGameInfo;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class RmiClientImpl extends UnicastRemoteObject implements ClientRmiAPi {
    private MainClientDAOListener listener;

    public RmiClientImpl(MainClientDAOListener listener) throws RemoteException {
        this.listener = listener;
    }
    @Override
    public void modelChanged(StartGameInfo data) throws RemoteException {
        // Extract maze and player name from StartGameInfo
        int[][] maze = data.getMaze();
        int playerName = data.getPlayerId();

        System.out.println("Received maze: " + maze);
        System.out.println("Player Name: " + playerName);

        // Use the maze to create or update the game model (DynamicGameModel)
        DynamicGameModel gameModel = new DynamicGameModel();
//        gameModel.setPlayers()  // Assuming DynamicGameModel has a setMaze method
//        gameModel.setSprites();  // Assuming DynamicGameModel has a setPlayerName method

        // Notify the listener that the game model has been updated
        listener.onModelChanged(gameModel);
    }
}

