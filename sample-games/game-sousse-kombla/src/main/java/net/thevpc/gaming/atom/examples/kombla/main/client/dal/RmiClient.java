package net.thevpc.gaming.atom.examples.kombla.main.client.dal;

import net.thevpc.gaming.atom.examples.kombla.main.shared.dal.RmiApiServeur;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.logging.Level;
import java.util.logging.Logger;

public class RmiClient {
    Registry r;


    public static void main(String[] args) {
        try {
            Registry r = LocateRegistry.getRegistry("localhost", 1234);

            RmiApiServeur a = (RmiApiServeur) r.lookup("RmiApiServeur");
            System.out.println(a.getClass().getName());
        } catch (Exception ex) {
            Logger.getLogger(RmiClient.class.getName()).log(Level.SEVERE, null, ex);
        }

    }}
