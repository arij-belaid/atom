package net.thevpc.gaming.atom.examples.kombla.main.client.dal;

import net.thevpc.gaming.atom.examples.kombla.main.shared.model.DynamicGameModel;
import net.thevpc.gaming.atom.examples.kombla.main.shared.model.StartGameInfo;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ClientRmiAPi extends Remote {
    public void modelChanged(StartGameInfo data) throws RemoteException;
}