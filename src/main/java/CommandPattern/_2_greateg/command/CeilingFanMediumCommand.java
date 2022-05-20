package CommandPattern._2_greateg.command;

import CommandPattern._1_badeg.homeApp.CeilingFan;

public class CeilingFanMediumCommand extends CeilingFanHighCommand{

    public CeilingFanMediumCommand(CeilingFan ceilingFan) {
        super(ceilingFan);
    }

    @Override
    public int getCurrentSpeed() {
        return CeilingFan.MEDIUM;
    }
}
