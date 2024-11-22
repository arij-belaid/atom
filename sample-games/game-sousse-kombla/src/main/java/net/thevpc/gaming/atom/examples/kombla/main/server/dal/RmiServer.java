package net.thevpc.gaming.atom.examples.kombla.main.server.dal;

import net.thevpc.gaming.atom.examples.kombla.main.shared.dal.ProtocolConstants;
import net.thevpc.gaming.atom.examples.kombla.main.shared.dal.RmiApiClient;
import net.thevpc.gaming.atom.examples.kombla.main.shared.dal.RmiApiServeur;
import net.thevpc.gaming.atom.examples.kombla.main.shared.engine.AppConfig;
import net.thevpc.gaming.atom.examples.kombla.main.shared.model.DynamicGameModel;
import net.thevpc.gaming.atom.examples.kombla.main.shared.model.StartGameInfo;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

public class RmiServer extends UnicastRemoteObject
        implements RmiApiServeur {

    private MainServerDAOListener listener;
    private AppConfig properties;
    private  StartGameInfo data;
    private DynamicGameModel dynamicGameModel;
    protected RmiServer() throws RemoteException {

    }
    private List<RmiApiClient> clients = new ArrayList<>();
    public void main(String[] args) throws InterruptedException {

        try {
            this.data = this.listener.onReceivePlayerJoined(properties.getPlayerName());
            Registry r = LocateRegistry.createRegistry(1234);

            r.bind("RmiApiServeur", new RmiServer());
            Object x = new Object();
            synchronized (x) {
                x.wait();
            }
        }catch (RuntimeException | RemoteException | AlreadyBoundException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public StartGameInfo connect(String name) throws RemoteException {


        return null;
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
}
