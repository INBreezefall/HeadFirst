package SingletonPattern.multipleThread._1_badeg;

/**
 * 订货商 Buyer
 * 对于 ChocolateBoiler 会有复数个 订货商 向其发起 订货请求
 * 这个地方可以留一个小作业: 将 ChocolateBoiler 增加 容量属性，然后进行多线程调用业务三件套，观测容量变化
 */
public class Buyer extends Thread {
    @Override
    public void run() {
        ChocolateBoiler instance = ChocolateBoiler.getInstance();
        System.out.println(instance.hashCode() + " " + Thread.currentThread().getName());
        instance.fill();
        instance.boil();
        instance.drain();
    }
}
