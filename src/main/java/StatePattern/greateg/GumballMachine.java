package StatePattern.greateg;

import StatePattern.greateg.stateImpl.HasQuarterState;
import StatePattern.greateg.stateImpl.NoQuarterState;
import StatePattern.greateg.stateImpl.SoldState;

/**
 * 改造步骤
 * 1.使用 接口体系 替换 if else [Interface 在 jdk 1.8 后 具备默认方法 default 实现 省下不少时间]
 * 2.实现 状态接口实现类
 * 3.
 */
public class GumballMachine {

    // 1.状态定义
    GumballMachineState soldOutState;
    GumballMachineState noQuarterState;
    GumballMachineState hasQuarterState;
    GumballMachineState soldState;
    GumballMachineState state = soldOutState;
    int count = 0;

    // 2.构造器初始化
    public GumballMachine(int numberGumballs) {
        count = numberGumballs;
        soldOutState = new SoldState(this);
        noQuarterState = new NoQuarterState(this);
        hasQuarterState = new HasQuarterState(this);
        soldState = new SoldState(this);
        if (numberGumballs > 0) {
            state = noQuarterState;
        }
    }

    // 3.获取状态实例 用于作为 setState() 传入参数
    public GumballMachineState getSoldOutState() {
        return soldOutState;
    }

    public GumballMachineState getNoQuarterState() {
        return noQuarterState;
    }

    public GumballMachineState getHasQuarterState() {
        return hasQuarterState;
    }

    public GumballMachineState getSoldState() {
        return soldState;
    }

    public GumballMachineState getState() {
        return state;
    }

    // 4.更新状态机当前状态
    public void setState(GumballMachineState state) {
        this.state = state;
    }

    // 5.面向用户的 公开 动作
    public void  insertQuarter() {
        state.insertQuarter();
    }

    public void ejectQuarter() {
        state.ejectQuarter();
    }

    public void truckCrank() {
        state.turnCrank();
        state.dispense();   // dispense 是一个状态内部动作，并不是一个开放给 用户 的 公开动作
    }

    // 6.状态机内部动作
    void releaseBall() {
        System.out.println("A gumball rolling out the slot...");
        if (count != 0) {
            count -= 1;
        }
    }
}
