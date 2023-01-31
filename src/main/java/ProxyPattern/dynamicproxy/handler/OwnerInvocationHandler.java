package ProxyPattern.dynamicproxy.handler;

import ProxyPattern.dynamicproxy.bean.Person;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * <pre>
 * Java Dynamic Proxy 实质上是 对于 函数调用权限 的控制，而非具体的 被代理对象的全部(实例属性 + 函数) / 某个实例属性
 * 通过 JDK 反射 Dynamic Proxy 实现对于 通用的  class 的代理
 *
 * Virtual Proxy 实现的是 针对 ImageIcon 这一具体的特别的类的代理，而不能实现对于 通用的 class 的代理。
 *
 * 自我调用访问处理类
 * </pre>
 */
public class OwnerInvocationHandler implements InvocationHandler {
    private final Person person;

    public OwnerInvocationHandler(Person person) {
        this.person = person;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) {
        try {
            // 通配 筛选 全部方法中的某类型方法
            // 1.禁止特殊调用方法 [抛出异常]
            if (method.getName().equals("setHotOrNotRating")) {
                throw new IllegalAccessException("自身禁止设置 自己的 HotOrNotRating");
            }
            // 2.允许调用方法 [不做阻拦，原样调用]
            else if (method.getName().startsWith("get") || method.getName().startsWith("set")) {
                return method.invoke(person, args);
            }
            // 3.其他不允许的调用 [抛出异常] (2,3 可以合并，只是异常提示好看点)
            else
                throw new IllegalAccessException("不允许的方法调用: " + method.getName());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
