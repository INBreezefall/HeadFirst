package ProxyPattern.dynamicproxy.handler;

import ProxyPattern.dynamicproxy.bean.Person;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 非自我 / 他人访问处理类
 */
public class NonOwnerInvocationHandler implements InvocationHandler {
    private final Person person;

    public NonOwnerInvocationHandler(Person person) {
        this.person = person;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) {
        try {
            // 通配 筛选 全部方法中的某类型方法
            // 1.允许调用方法 [不做阻拦，原样调用]
            if (method.getName().equals("setHotOrNotRating") || method.getName().startsWith("get")) {
                return method.invoke(person, args);
            }
            // 2.禁止特殊调用方法 [抛出异常]
            else if (method.getName().startsWith("set")) {
                throw new IllegalAccessException("他人禁止设置 非 HotOrNotRating 属性");
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
