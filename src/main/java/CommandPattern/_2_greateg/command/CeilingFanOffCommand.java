package CommandPattern._2_greateg.command;

import CommandPattern._1_badeg.homeApp.CeilingFan;

public class CeilingFanOffCommand extends CeilingFanHighCommand {
    public CeilingFanOffCommand(CeilingFan ceilingFan) {
        super(ceilingFan);
    }

    @Override
    public int getCurrentSpeed() {
        return CeilingFan.OFF;
    }
}
