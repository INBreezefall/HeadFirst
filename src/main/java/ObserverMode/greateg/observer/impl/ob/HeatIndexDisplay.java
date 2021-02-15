package ObserverMode.greateg.observer.impl.ob;

import ObserverMode.greateg.observer.DisplayElement;
import ObserverMode.greateg.observer.Observer;
import ObserverMode.greateg.observer.Subject;

public class HeatIndexDisplay implements Observer, DisplayElement {
    private float temperature;
    private float humidity;
    private Subject weatherData;

    /**
     * Observer 实例初始化时 主动绑定 Subject 并 主动调用 Subjec.register 向 Subject 注册 被动调用 update
     * Subject 在内存中 被动维护 Observers 列表，被动 增添、删除，主动调用 notify 通知 Observers
     *
     * @param weatherData Subject
     */
    public HeatIndexDisplay(Subject weatherData) {
        this.weatherData = weatherData;
        this.weatherData.registerObserver(this);
    }

    @Override
    public void update(float temperature, float humidity, float pressure) {
        this.temperature = temperature;
        this.humidity = humidity;
        display(); // 如果是 MVC 模式 则 应改到 Controller 层
    }

    @Override
    public void display() {
        System.out.println("Heat index is conditions: " + computeHeatIndex(temperature, humidity));
    }

    private float computeHeatIndex(float t, float rh) {
        return (float)((16.923 + (0.185212 * t) + (5.37941 * rh) - (0.100254 * t * rh) +
                (0.00941695 * (t * t)) + (0.00728898 * (rh * rh)) +
                (0.000345372 * (t * t * rh)) - (0.000814971 * (t * rh * rh)) +
                (0.0000102102 * (t * t * rh * rh)) - (0.000038646 * (t * t * t)) + (0.0000291583 *
                (rh * rh * rh)) + (0.00000142721 * (t * t * t * rh)) +
                (0.000000197483 * (t * rh * rh * rh)) - (0.0000000218429 * (t * t * t * rh * rh)) +
                0.000000000843296 * (t * t * rh * rh * rh)) -
                (0.0000000000481975 * (t * t * t * rh * rh * rh)));
    }
}
