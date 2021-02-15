package ObserverMode.greateg;

import ObserverMode.greateg.observer.impl.ob.CurrentConditionsDisplay;
import ObserverMode.greateg.observer.impl.ob.HeatIndexDisplay;
import ObserverMode.greateg.observer.impl.subject.WeatherData;

public class Main {
    public static void main(String[] args) {
        WeatherData weatherData = new WeatherData();

        CurrentConditionsDisplay currentConditionsDisplay = new CurrentConditionsDisplay(weatherData);
        HeatIndexDisplay heatIndexDisplay = new HeatIndexDisplay(weatherData);

        weatherData.setMeasurements(80,65,30.4f);
        weatherData.setMeasurements(82,70,29.2f);
        weatherData.setMeasurements(78,90,29.2f);
    }
}
