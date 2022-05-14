package SingletonPattern.multipleThread._1_badeg;

/**
 * 懒汉式单例设计 在 多线程执行下
 * 实现步骤:
 * 1.私有化构造器
 * 2.创建静态对象
 * 3.创建静态方法获取静态对象
 *
 * 注意: 当你私有化无参构造器时，就意味着无法继承 extends
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
    public static ChocolateBoiler getInstance() {
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
