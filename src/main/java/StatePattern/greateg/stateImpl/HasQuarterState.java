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
        System.out.println("You can't insert another quarter");
    }

    @Override
    public void ejectQuarter() {
        System.out.println("Quarter returned");
        gumballMachine.setState(gumballMachine.getNoQuarterState());
    }

    @Override
    public void turnCrank() {
        System.out.println("You turned...");
        gumballMachine.setState(gumballMachine.getSoldState());
    }

    @Override
    public void dispense() {
        System.out.println("This time no gumball should dispensed");
    }
}
