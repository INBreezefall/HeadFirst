package ProxyPattern.remoteproxy.diversejvm.service;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;

public class MyRemoteServiceImpl extends UnicastRemoteObject implements MyRemoteService {
    protected MyRemoteServiceImpl() throws RemoteException {
    }

    @Override
    public String sayHello() throws RemoteException {
        return "haha Test";
    }

    public static void main(String[] args) {
        try {
            MyRemoteServiceImpl service = new MyRemoteServiceImpl();
            LocateRegistry.createRegistry(1099);
            Naming.rebind("RemoteHello", service);
            System.err.println("Server ready");
        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }
}
