package ProxyPattern.dynamicproxy;

import ProxyPattern.dynamicproxy.bean.Person;

/**
 * <pre>
 * 动态代理 无需自己写特定某个类型的 Proxy 代理类，而是使用 由 JDK 提供的通用 Proxy 代理类
 * 在运行时 通过 Proxy.newProxyInstance() 产生 Proxy 实例，再通过 强转 来代理 特定某个类型
 *
 * InvocationHandler 是 最重要的一环，它决定了 被代理对象的函数调用 能否成功
 *
 * Proxy 动态代理实例 除了具有 被代理类 的 公共方法，还具有其他方法/接口的方法 (isProxyClass())
 *
 * Proxy.newProxyInstance() 传入的接口数组 具有一定限制，详见 JavaDoc
 * </pre>
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("初始化 Alien...");
        // 取出自己
        Person own = Person.getPersonFromRandom("Alien");
        System.out.println("初始化 Alien 结束");
        // 设置 自我访问类型代理
        Person ownerProxy = Person.getOwnerProxy(own);

        System.out.println("\nAline 访问 Alien...");
        // 正确调用
        ownerProxy.setInterests("Bowling, Go\n");
        // 非正确调用
        ownerProxy.setHotOrNotRating(100);

        System.out.println("初始化 Bob...");
        // 取出他人
        Person other = Person.getPersonFromRandom("Bob");
        System.out.println("初始化 Bob 结束");
        // 设置 非自我访问类型代理
        Person otherProxy = Person.getNonOwnerProxy(other);

        System.out.println("\nAline 访问 Bob...");
        // 正确调用
        otherProxy.setHotOrNotRating(100);
        // 非正确调用
        otherProxy.setInterests("Bowling, Go");
    }
}
