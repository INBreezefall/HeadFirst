package StatePattern.homework.stateImpl;

import StatePattern.homework.GumballMachine;
import StatePattern.homework.GumballMachineState;

/**
 * 售罄状态
 */
public class SoldOutState implements GumballMachineState {
    GumballMachine gumballMachine;

    public SoldOutState(GumballMachine gumballMachine) {
        this.gumballMachine = gumballMachine;
    }

    @Override
    public void insertQuarter() {
        System.out.println("You can't insert a quarter, because the machine is sold out");
    }

    @Override
    public void ejectQuarter() {
        System.out.println("You haven't inserted a quarter, because the machine is sold out");
    }

    @Override
    public void turnCrank() {
        System.out.println("You turned but there's no gumballs");
    }

    @Override
    public void dispense() {
        System.out.println("This time no gumball should dispensed");
    }

    @Override
    public void refill(int count) {
        // 1.修改 糖果机 计数器
        gumballMachine.setCount(count);
        // 2.修改 糖果机 当前状态
        gumballMachine.setState(gumballMachine.getNoQuarterState());
    }
}
