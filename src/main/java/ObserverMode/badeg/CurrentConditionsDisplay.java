package ObserverMode.badeg;

import ObserverMode.badeg.ob.Display;
import ObserverMode.greateg.observer.DisplayElement;
import ObserverMode.greateg.observer.Observer;
import ObserverMode.greateg.observer.Subject;

public class CurrentConditionsDisplay extends Display {
    public void update(float temperature, float humidity, float pressure) {

    }

    public void display() {
        System.out.println("Current conditions: " + temperature + "F degrees and "
                + humidity + "% humidity");
    }
}
