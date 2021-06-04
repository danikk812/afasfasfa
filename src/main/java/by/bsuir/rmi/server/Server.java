package by.bsuir.rmi.server;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class Server {
    private static final String REGISTRY_NAME = "StringOperation";
    private static final Integer PORT_DEFAULT = 0;
    private static final Integer PORT = 1099;

    public static void main(String[] args) {
        if (System.getSecurityManager() == null) {
            System.setSecurityManager(new SecurityManager());
        }
        try {
            StringOperation stringOperation = new StringOperationImpl();
            StringOperation stub = (StringOperation) UnicastRemoteObject.exportObject(stringOperation, PORT_DEFAULT);
            Registry registry = LocateRegistry.createRegistry(PORT);
            registry.bind(REGISTRY_NAME, stub);
            System.out.println("Bound " + REGISTRY_NAME);
        } catch (RemoteException | AlreadyBoundException e) {
            System.out.println("Communication exception: " + e.getMessage());
        }
    }
}
