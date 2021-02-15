package ObserverMode.jdk;


import ObserverMode.jdk.observer.ob.CurrentConditionsDisplay;
import ObserverMode.jdk.observer.ob.ForecastDisplay;
import ObserverMode.jdk.observer.subject.WeatherData;

public class Main {
    public static void main(String[] args) {
        WeatherData weatherData = new WeatherData();

        CurrentConditionsDisplay currentConditionsDisplay = new CurrentConditionsDisplay(weatherData);
        ForecastDisplay forecastDisplay = new ForecastDisplay(weatherData);

        weatherData.setMeasurements(80,65,30.4f);
        weatherData.setMeasurements(82,70,29.2f);
        weatherData.setMeasurements(78,90,29.2f);
    }
}
