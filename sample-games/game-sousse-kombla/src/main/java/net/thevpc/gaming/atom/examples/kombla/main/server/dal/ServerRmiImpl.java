package net.thevpc.gaming.atom.examples.kombla.main.server.dal;

import net.thevpc.gaming.atom.examples.kombla.main.client.dal.ClientRmiAPi;
import net.thevpc.gaming.atom.examples.kombla.main.client.dal.MainClientDAOListener;
import net.thevpc.gaming.atom.examples.kombla.main.client.dal.RmiClientImpl;
import net.thevpc.gaming.atom.examples.kombla.main.shared.model.StartGameInfo;

import java.io.IOException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class ServerRmiImpl extends UnicastRemoteObject implements ServerRmiApi {
    private MainClientDAOListener listener;
    public ServerRmiImpl(MainClientDAOListener listener) throws RemoteException {
        this.listener = listener;
    }

    @Override
    public StartGameInfo connect(String name) throws RemoteException {
        return null;
    }

    @Override
    public void disconnect(String name) throws RemoteException {

    }

    @Override
    public void startGame(String name) throws RemoteException {

    }

    @Override
    public void stopGame(String name) throws RemoteException {

    }

    @Override
    public void onReceiveMoveLeft(int playerId) throws IOException {

    }

    @Override
    public void onReceiveMoveRight(int playerId) throws RemoteException {

    }

    @Override
    public void onReceiveMoveUp(int playerId) throws RemoteException {

    }

    @Override
    public void onReceiveMoveDown(int playerId) throws RemoteException {

    }

    @Override
    public void onReceiveReleaseBomb(int playerId) {

    }

    @Override
    public void setClient(RmiClientImpl rmiClientImpl) {

    }
}
