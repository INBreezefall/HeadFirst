package SingletonPattern.multipleThread._2_improvedeg;

/**
 * 改进版
 * 这里的代码 和 badeg 基本相同
 * 除了 getInstance 方法增加了一个 方法修饰符 synchronized
 * synchronized 是 JVM 实现的关键字
 * 该关键字主要作用是 令 每个线程进入该方法之前 都需要不断等待 别的线程离开该方法，自己才能进入
 * 也就是说 -- 这个方法一旦被 synchronized 修饰 就不会同时有 2 个方法同时进入
 *
 * 缺点: synchronized 带来的性能下降
 * 问题实质: 懒汉式单例模式 只需要在 初始化的时候同步，而后续获取的时候并不需要，这就成为了累赘
 * 缺点解决:
 * 1.如果你不关心这点性能，那就什么都不需要做了
 * 2.你可以 不使用 懒汉式单例模式 直接在类初始化时进行赋值即可
 * 3.更加美妙的 volatile (greateg 见)
 */
public class ChocolateBoiler {
    private boolean empty;
    private boolean boiled;

    // 单例三件套
    // 2.静态对象
    private static ChocolateBoiler chocolateBoiler;

    // 1.私有构造器
    private ChocolateBoiler() {
        empty = true;
        boiled = false; // default = false 可不写
    }

    // 3.静态方法
    public static synchronized ChocolateBoiler getInstance() {
        if (chocolateBoiler == null) {
            chocolateBoiler = new ChocolateBoiler();
        }
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
