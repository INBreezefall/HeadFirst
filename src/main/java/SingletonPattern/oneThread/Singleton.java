package SingletonPattern.oneThread;

/**
 * 另一个俗名 懒汉式单例模式 -- 真正需要使用时才进行实例化
 * 这也是 相较于全局变量的一个优点: 延迟实例化 [单线程下 这些模式都是没有任何问题的]
 */
@SuppressWarnings("unused")
public class Singleton {
    /**
     * 唯一的静态实例对象 singleton
     * 静态变量也无法被子类继承，他就是个当前类的静态变量，不属于任何子类
     * 由于 private 修饰 子类是无法访问的
     */
    private static Singleton singleton;

    /**
     * 实质上将构造器权限设置为 私有，除了当前类的内部以外都无法进行实例化
     * 这里就会导致子类无法继承
     */
    private Singleton() {}

    /**
     * 如果想要获取 Singleton 对象只能通过 静态方法 getInstance 获取 唯一的静态实例对象 singleton
     * WARNING: 这里 IDEA 进行了警告 说 我们没有必要对这个类进行实例化
     * 只需要直接调用静态方法即可，因为这个类中只有静态方法及静态变量
     * 确实 这种类型的 class 本身即可认为是单例的，堆中只存一份只初始化一次
     * @return 获取全局唯一实例 singleton
     */
    public static Singleton getInstance() {
        if (singleton == null)
            singleton = new Singleton();
        return singleton;
    }
}