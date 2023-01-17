package StatePattern.homework.stateImpl;

import StatePattern.homework.GumballMachine;
import StatePattern.homework.GumballMachineState;

/**
 * 大乐透状态 [十次抽中一次 出 2 个糖果]
 * 为什么要单独出一个类， 而不是写在 SoldState 中 --> 单一职责原则 [已存在的类 面向修改封闭] 当然也可以折中考虑
 */
public class WinnerState implements GumballMachineState {
    // 这个地方可以抽象类 作为成员变量
    GumballMachine gumballMachine;

    public WinnerState(GumballMachine gumballMachine) {
        this.gumballMachine = gumballMachine;
    }

    @Override
    public void insertQuarter() {
        System.out.println("Please wait, we're giving you a gumball");
    }

    @Override
    public void ejectQuarter() {
        System.out.println("Sorry, you already turned the crank");
    }

    @Override
    public void turnCrank() {
        System.out.println("Sorry, you just now turned the crank");
    }

    @Override
    public void dispense() {
        gumballMachine.releaseBall();
        if (gumballMachine.getCount() > 0) {
            gumballMachine.setState(gumballMachine.getNoQuarterState());
        } else {
            // 释放 第二颗 糖果
            gumballMachine.releaseBall();
            if (gumballMachine.getCount() > 0) {
                gumballMachine.setState(gumballMachine.getNoQuarterState());
            } else {
                gumballMachine.setState(gumballMachine.getSoldOutState());
            }
        }
    }
}
