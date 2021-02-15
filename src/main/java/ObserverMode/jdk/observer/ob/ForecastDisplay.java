package ObserverMode.jdk.observer.ob;

import ObserverMode.greateg.observer.DisplayElement;
import ObserverMode.jdk.observer.subject.WeatherData;

import java.util.Observable;
import java.util.Observer;

public class ForecastDisplay implements Observer, DisplayElement {
    private float currentPressure = 29.92f;
    private float lastPressure;

    public ForecastDisplay(Observable o) {
        o.addObserver(this);
    }

    @Override
    public void update(Observable o, Object arg) {
        if (o instanceof WeatherData) {
            this.lastPressure = this.currentPressure;
            this.currentPressure = ((WeatherData) o).getPressure();
            display();
        }
    }

    @Override
    public void display() {
        System.out.println("ForecastDisplay lastPressure: " + lastPressure + ", "
                + "currentPressure: " + currentPressure);
    }
}
