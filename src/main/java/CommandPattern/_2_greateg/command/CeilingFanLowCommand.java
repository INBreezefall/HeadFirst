package CommandPattern._2_greateg.command;

import CommandPattern._1_badeg.homeApp.CeilingFan;

public class CeilingFanLowCommand extends CeilingFanHighCommand{

    public CeilingFanLowCommand(CeilingFan ceilingFan) {
        super(ceilingFan);
    }

    @Override
    public int getCurrentSpeed() {
        return CeilingFan.LOW;
    }
}
