package ProxyPattern.remoteproxy.diversejvm.client;

import ProxyPattern.remoteproxy.diversejvm.service.MyRemoteService;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class MyClient {
    public void go() {
        try {
            MyRemoteService service = (MyRemoteService) Naming.lookup("rmi://127.0.0.1/RemoteHello");
            System.out.println(service.sayHello());
        } catch (MalformedURLException | RemoteException | NotBoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        new MyClient().go();
    }
}
