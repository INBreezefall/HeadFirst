package ProxyPattern.remoteproxy.diversejvm;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Client {

    private Client() {}

    public static void main(String[] args) {

        String host = (args.length < 1) ? null : args[0];
        int port = (args.length < 2) ? 0 : Integer.parseInt(args[1]);
        try {
            Registry registry = LocateRegistry.getRegistry(host, port);
            Hello stub = (Hello) registry.lookup("Hello");
            String response = stub.sayHello();
            System.out.println("response: " + response);
        } catch (Exception e) {
            System.err.println("Client exception: " + e);
            e.printStackTrace();
        }
    }
}