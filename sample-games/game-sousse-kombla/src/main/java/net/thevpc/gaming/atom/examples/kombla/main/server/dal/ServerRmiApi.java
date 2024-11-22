package net.thevpc.gaming.atom.examples.kombla.main.server.dal;

import net.thevpc.gaming.atom.examples.kombla.main.client.dal.RmiClientImpl;
import net.thevpc.gaming.atom.examples.kombla.main.shared.model.StartGameInfo;

import java.io.IOException;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ServerRmiApi extends Remote {
    StartGameInfo connect(String name) throws RemoteException;
   void disconnect(String name) throws RemoteException;
void startGame(String name) throws RemoteException;

void stopGame(String name)throws RemoteException;

    void onReceiveMoveLeft(int playerId) throws IOException;

    void onReceiveMoveRight(int playerId) throws RemoteException;

    void onReceiveMoveUp(int playerId)throws RemoteException;

    void onReceiveMoveDown(int playerId)throws RemoteException;

    void onReceiveReleaseBomb(int playerId);

    void setClient(RmiClientImpl rmiClientImpl);
}
