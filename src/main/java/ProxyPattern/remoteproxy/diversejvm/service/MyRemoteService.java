package ProxyPattern.remoteproxy.diversejvm.service;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface MyRemoteService extends Remote {
    public String sayHello() throws RemoteException;
}
