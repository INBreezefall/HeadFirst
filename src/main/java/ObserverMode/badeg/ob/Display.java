package ObserverMode.badeg.ob;

/**
 * 布告板抽象基类
 * 属性：温度，湿度，压强
 * 方法：更新，展示
 */
public abstract class Display {
    protected float temperature;
    protected float humidity;
    private float pressure;

    abstract public void update(float temperature, float humidity, float pressure);
    abstract public void display();
}
