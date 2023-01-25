package ProxyPattern.remoteproxy.diversejvm;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * <pre>
 * 执行步骤
 * 1.自定义服务接口(Hello) 拓展 Remote 接口
 * 2.实现 自定义服务接口(Server)
 * 3.启动 rmiregistry 进程 [注意 启动位置， rmiregistry 是 JDK 默认环境携带的可执行文件 默认加载自己启动时的当前目录]
 *     常见错误
 *     1.Connection refused to host: 127.0.0.1 [rmiregistry 进程必须在 Server 进程前启动]
 *     2.java.rmi.NoSuchObjectException: no such object in table [Server 端口号 写成了 注册中心默认端口 1099 存在冲突]
 *     3.java.lang.ClassNotFoundException: ProxyPattern.remoteproxy.rmi.hello.Hello [rmiregistry 启动目录不正确]
 *          MacOS: 本项目正确的启动路径 ~/IdeaProjects/HeadFirst/target/classes
 * 4.启动 自定义服务(Server) 进程 向 rmiregistry 服务注册 stub (客户端桩对象)
 * 5.启动 Client 进程 请求 rmiregistry 服务返回 stub
 * 6.Client 通过 Server-Stub 进行 远程方法调用 Remote Method Invocation 并得到结果
 *
 * 源码资源: <a href="https://tttang.com/archive/1530/">源码层面梳理Java RMI交互流程</a>
 * </pre>
 */
public interface Hello extends Remote {
    String sayHello() throws RemoteException;
}