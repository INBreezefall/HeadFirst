package SingletonPattern.multipleThread._3_greateg;

/**
 * 最终优势版
 * 这里和 improvedeg 基本相同
 * 除了 静态变量 chocolateBoiler\empty\boiled 增加了变量修饰符 volatile
 * 以及 将 synchronized 移入 getInstance 内部 仅锁住 赋值语句
 *
 * volatile 关键字由 JVM 实现
 * 该关键字主要作用是 标记一个变量只从 主存 获取，不从 各个 CPU 缓存变量副本 获取
 * 这个关键字 在这里 主要即是 保障 多线程之间 chocolateBoiler 静态变量的可见性
 * 一定不会出现 多核 CPU 缓存变量副本 == null 导致的重复赋值的情况
 *
 * 注意:
 * 1.不要在 jdk 1.4 及其以上 使用 volatile 因为他们的实现存在问题
 * 2.jdk 1.2 及其以上 存在一个 GC bug
 *      如果 单例对象没有一个全局引用 会被当做 垃圾清除 从而导致重新生成一个默认配置的单例对象
 * 3.如果存在 多个 ClassLoader 都可以加载 单例类，那确实可能造成产生多个单例对象的怪异现象
 *      解决方法: 指定某一个类加载器 [每个类加载器可以认为是 一个独立的命名空间]
 * 4.类中属性及方法全搞成静态，确实也可以，例如一个工具类，自给自足 不依赖外部复杂初始化
 *      这可能存在一个 Jvm 静态类初始化次序 BUG，使用对象的单例/单件比较保险
 *      全搞成静态和全局变量其实很类似，都会存在一个 初始化顺序问题 需要程序员自己来进行仔细检查
 */
public class ChocolateBoiler {
    private volatile boolean empty;
    private volatile boolean boiled;

    // 单例三件套
    // 2.静态对象
    private volatile static ChocolateBoiler chocolateBoiler;

    // 1.私有构造器
    private ChocolateBoiler() {
        empty = true;
        boiled = false; // default = false 可不写
    }

    // 3.静态方法
    public static ChocolateBoiler getInstance() {
        if (chocolateBoiler == null) {
            // 仅锁住 赋值语句
            synchronized (ChocolateBoiler.class) {
                if (chocolateBoiler == null) {
                    chocolateBoiler = new ChocolateBoiler();
                }
            }
        }
        // 不锁 返回语句
        return chocolateBoiler;
    }

    // 业务三件套
    // 1.填充巧克力
    public void fill() {
        if (isEmpty()) {
            System.out.println("1.加入原料 " + Thread.currentThread().getName());
            empty = false;
            boiled = false;
        }
    }

    // 2.煮沸
    public void boil() {
        if (!isEmpty() && !isBoiled()) {
            System.out.println("2.煮沸中 " + Thread.currentThread().getName());
            boiled = true;
        }
    }

    // 3.排出
    public void drain() {
        if (!isEmpty() && isBoiled()) {
            System.out.println("3.排出成品 " + Thread.currentThread().getName());
            empty = true;
        }
    }

    private boolean isBoiled() {
        return boiled;
    }

    private boolean isEmpty() {
        return empty;
    }
}
