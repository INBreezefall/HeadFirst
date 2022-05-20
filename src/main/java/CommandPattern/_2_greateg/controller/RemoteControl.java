package CommandPattern._2_greateg.controller;

import CommandPattern._2_greateg.command.Command;
import CommandPattern._2_greateg.command.NoCommand;

import java.util.Arrays;

public class RemoteControl {
    // 具有 on() off() 行为的 command 中间层
    Command[] onCommands;
    Command[] offCommands;

    Command lastCommands;

    // 初始化
    public RemoteControl() {
        NoCommand noCommand = new NoCommand();
        onCommands = new Command[7];
        offCommands = new Command[7];
        Arrays.fill(onCommands, noCommand);
        Arrays.fill(offCommands, noCommand);
    }

    public void setOnCommand(int slot, Command command) {
        onCommands[slot] = command;
    }

    public void setOffCommand(int slot, Command command) {
        offCommands[slot] = command;
    }

    public void onButtonPushed(int slot) {
        onCommands[slot].execute();
        lastCommands = onCommands[slot];
    }

    public void offButtonPushed(int slot) {
        offCommands[slot].execute();
        lastCommands = offCommands[slot];
    }

    public void undoButtonPushed() {
        lastCommands.undo();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\n------ Remote Control ------\n");
        for (int i = 0; i < onCommands.length; i++) {
            sb.append(String.format("[slot %d] On: %s  Off: %s\n",
                    i, onCommands[i].getClass().getName(), offCommands[i].getClass().getName()));
        }
        return sb.toString();
    }
}
