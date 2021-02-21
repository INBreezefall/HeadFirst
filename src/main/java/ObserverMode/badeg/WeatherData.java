package ObserverMode.badeg;

public class WeatherData {
    private float temperature;
    private float humidity;
    private float pressure;

    private HeatIndexDisplay hDisplay;
    private CurrentConditionsDisplay cDisplay;
    // +
    // -
    // 布告板数量变化 都需要修改 WeatherData 类

    public WeatherData(HeatIndexDisplay heat, CurrentConditionsDisplay current) {
        this.hDisplay = heat;
        this.cDisplay = current;
    }

    public void notifyAllDisplay() {
        hDisplay.update(temperature, humidity, pressure);
        cDisplay.update(temperature, humidity, pressure);
    }
}
