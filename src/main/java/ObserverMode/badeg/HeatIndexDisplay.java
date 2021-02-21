package ObserverMode.badeg;

import ObserverMode.badeg.ob.Display;
import ObserverMode.greateg.observer.DisplayElement;
import ObserverMode.greateg.observer.Observer;
import ObserverMode.greateg.observer.Subject;

public class HeatIndexDisplay extends Display {

    public void update(float temperature, float humidity, float pressure) {
        this.temperature = temperature;
        this.humidity = humidity;
        display(); // 如果是 MVC 模式 则 应改到 Controller 层
    }

    public void display() {
        System.out.println("Heat index is conditions: " + humidity);
    }
}
