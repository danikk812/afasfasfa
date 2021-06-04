package by.bsuir.rmi.server;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface StringOperation extends Remote {

    String sumDigit(String inputString) throws RemoteException;

    String formWord(String inputString) throws RemoteException;
}
