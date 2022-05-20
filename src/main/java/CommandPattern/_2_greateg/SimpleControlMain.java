package CommandPattern._2_greateg;

import CommandPattern._1_badeg.homeApp.Light;
import CommandPattern._2_greateg.controller.SimpleRemoteControl;
import CommandPattern._2_greateg.command.LightOnCommand;

public class SimpleControlMain {
    public static void main(String[] args) {
        SimpleRemoteControl control = new SimpleRemoteControl();
        Light light = new Light();
        LightOnCommand lightOnCommand = new LightOnCommand(light);
        control.setCommand(lightOnCommand);
        control.buttonWashPressed();
    }
}
