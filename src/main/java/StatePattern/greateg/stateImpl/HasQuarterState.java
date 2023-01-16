package StatePattern.greateg.stateImpl;

import StatePattern.greateg.GumballMachine;
import StatePattern.greateg.GumballMachineState;

/**
 * 应用组合 而非 继承
 */
public class HasQuarterState implements GumballMachineState {
    GumballMachine gumballMachine;

    public HasQuarterState(GumballMachine gumballMachine) {
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
