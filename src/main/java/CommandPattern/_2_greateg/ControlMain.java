package CommandPattern._2_greateg;

import CommandPattern._1_badeg.homeApp.CeilingFan;
import CommandPattern._1_badeg.homeApp.Light;
import CommandPattern._2_greateg.command.CeilingFanHighCommand;
import CommandPattern._2_greateg.command.CeilingFanOffCommand;
import CommandPattern._2_greateg.command.LightOffCommand;
import CommandPattern._2_greateg.command.LightOnCommand;
import CommandPattern._2_greateg.controller.RemoteControl;

public class ControlMain {
    public static void main(String[] args) {
        RemoteControl control = new RemoteControl();

        Light light = new Light();
        LightOnCommand lightOnCommand = new LightOnCommand(light);
        LightOffCommand lightOffCommand = new LightOffCommand(light);
        control.setOnCommand(0, lightOnCommand);
        control.setOffCommand(0, lightOffCommand);

        CeilingFan fan = new CeilingFan("LivingRoom");
        CeilingFanHighCommand ceilingFanHighCommand = new CeilingFanHighCommand(fan);
        CeilingFanOffCommand ceilingFanOffCommand = new CeilingFanOffCommand(fan);
        control.setOnCommand(1, ceilingFanHighCommand);
        control.setOffCommand(1, ceilingFanOffCommand);

        System.out.println(control);

        // 开灯 + 关灯 + 撤销
        control.onButtonPushed(0);
        control.offButtonPushed(0);
        control.undoButtonPushed();

        // 风扇高档 +  风扇关闭 + 撤销
        control.onButtonPushed(1);
        control.offButtonPushed(1);
        control.undoButtonPushed();
    }
}
