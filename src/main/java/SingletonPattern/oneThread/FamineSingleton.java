package SingletonPattern.oneThread;

/**
 * 俗名 饿汉式单例模式 -- 在类初始化时就进行实例创建 不会有任何线程问题
 */
public class FamineSingleton {
    private static final FamineSingleton singleton = new FamineSingleton();

    private FamineSingleton() {}

    private static FamineSingleton getInstance() {
        return singleton;
    }
}
