package by.bsuir.rmi.client;

import by.bsuir.rmi.server.StringOperation;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Arrays;
import java.util.Scanner;

public class Client {
    private static final String HOST = "127.0.0.1";
    private static final String REGISTRY_NAME = "StringOperation";

    public static void main(String[] args) {
        if (System.getSecurityManager() == null) {
            System.setSecurityManager(new SecurityManager());
        }
        runOperation();
    }

    public static void runOperation() {
        String resultString = null;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the alphanumeric string: ");
        String clientString = scanner.nextLine();
        System.out.println("1 - Sum the digits from the string");
        System.out.println("2 - Form the word from characters from the string");
            switch (scanner.nextInt()) {
                case 1:
                    try {
                        Registry registry = LocateRegistry.getRegistry(HOST);
                        StringOperation stringOperation = (StringOperation) registry.lookup(REGISTRY_NAME);
                        resultString = stringOperation.sumDigit(clientString);
                    } catch (RemoteException e) {
                        System.out.println("Connection is refused: " + e.getMessage());
                    } catch (NotBoundException e) {
                        System.out.println("Not bound: " + e.getMessage());
                    }
                    break;
                case 2:
                    try {
                        Registry registry = LocateRegistry.getRegistry(HOST);
                        StringOperation stringOperation = (StringOperation) registry.lookup(REGISTRY_NAME);
                        resultString = stringOperation.formWord(clientString);
                    } catch (RemoteException e) {
                        System.out.println("Connection is refused: " + e.getMessage());
                    } catch (NotBoundException e) {
                        System.out.println("Not bound: " + e.getMessage());
                    }
                    break;
                default:
                    System.out.println("Operation not found");
            }
        System.out.println(resultString);
    }
}

