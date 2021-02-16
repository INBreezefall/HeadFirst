package ObserverMode.custom.observer.impl.ob;


import ObserverMode.custom.observer.DisplayElement;
import ObserverMode.custom.observer.Observer;
import ObserverMode.custom.observer.Subject;
import ObserverMode.custom.observer.impl.subject.WeatherData;

@SuppressWarnings("unused")
public class CurrentConditionsDisplay implements Observer, DisplayElement {
    private float temperature;
    private float humidity;
    private final Subject weatherData;

    /**
     * Observer 实例初始化时 主动绑定 Subject 并 主动调用 Subjec.register 向 Subject 注册，被动调用 update
     * Subject 在内存中 被动维护 Observers 列表，被动 增添、删除，主动调用 notify 通知 Observers
     *
     * 这种模式是 Subject 主动推送 Message 至 Observer，但可能 Observer 并不想 在无法控制的时间 被动 被通知
     * @param weatherData Subject
     */
    public CurrentConditionsDisplay(Subject weatherData) {
        this.weatherData = weatherData;
        this.weatherData.addObserver(this);
    }

    @Override
    public void display() {
        System.out.println("Current conditions: " + temperature + "F degrees and "
                + humidity + "% humidity");
    }

    @Override
    public void update(Subject o, Object arg) {
        WeatherData weatherData = (WeatherData) o;
        this.temperature = weatherData.getTemperature();
        this.humidity = weatherData.getHumidity();
        display(); // 如果是 MVC 模式 则 应改到 Controller 层
    }

    public void removeSubject(){
        weatherData.deleteObserver(this);
    }
}
