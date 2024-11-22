package net.thevpc.gaming.atom.examples.kombla.main.shared.dal;

import net.thevpc.gaming.atom.examples.kombla.main.shared.model.StartGameInfo;

import java.io.IOException;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface RmiApiServeur extends Remote {
    StartGameInfo connect(String name) throws RemoteException;


    void onReceiveMoveLeft(int playerId) throws IOException;

    void onReceiveMoveRight(int playerId) throws RemoteException;

    void onReceiveMoveUp(int playerId)throws RemoteException;

    void onReceiveMoveDown(int playerId)throws RemoteException;

    void onReceiveReleaseBomb(int playerId);
}
