package ProxyPattern.remoteproxy.diversejvm;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

/**
 * JDK 8 官方教程
 */
public class Server implements Hello {

    public Server() {}

    public String sayHello() {
        return "Hello, world!";
    }

    public static void main(String[] args) {

        try {
            Server obj = new Server();
            // port 0 = 随机端口
            Hello stub = (Hello) UnicastRemoteObject.exportObject(obj, 1199);

            // Bind the remote object's stub in the registry
            Registry registry = LocateRegistry.getRegistry();
            registry.bind("Hello", stub);

            System.err.println("Server ready");
        } catch (Exception e) {
            System.err.println("Server exception: " + e);
            e.printStackTrace();
        }
    }
}