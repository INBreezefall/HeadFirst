package StatePattern.greateg.stateImpl;

import StatePattern.greateg.GumballMachine;
import StatePattern.greateg.GumballMachineState;

public class SoldState implements GumballMachineState {
    GumballMachine gumballMachine;

    public SoldState(GumballMachine gumballMachine) {
        this.gumballMachine = gumballMachine;
    }

    @Override
    public void insertQuarter() {

    }

    @Override
    public void ejectQuarter() {

    }

    @Override
    public void turnCrank() {

    }

    @Override
    public void dispense() {

    }
}
