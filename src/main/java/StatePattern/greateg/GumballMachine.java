package StatePattern.greateg;

import StatePattern.greateg.stateImpl.HasQuarterState;
import StatePattern.greateg.stateImpl.NoQuarterState;
import StatePattern.greateg.stateImpl.SoldState;
import StatePattern.greateg.stateImpl.WinnerState;
import StatePattern.greateg.stateImpl.SoldOutState;

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
    GumballMachineState winnerState;
    GumballMachineState state = soldOutState;
    int count;

    // 2.构造器初始化
    public GumballMachine(int numberGumballs) {
        count = numberGumballs;
        // 优化 —— 状态变量共享 通过 静态实例
        soldOutState = new SoldOutState(this);
        noQuarterState = new NoQuarterState(this);
        hasQuarterState = new HasQuarterState(this);
        soldState = new SoldState(this);
        winnerState = new WinnerState(this);
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

    // 4.更新状态机当前状态
    public void setState(GumballMachineState state) {
        this.state = state;
    }

    // 5.面向用户的 公开 动作
    public void  insertQuarter() {
        state.insertQuarter();
    }

    @SuppressWarnings("unused")
    public void ejectQuarter() {
        state.ejectQuarter();
    }

    /**
     * <pre>10 抽 1 特奖状态 是 摇杆行为执行后 的 三种状态(另外两种是售出、售罄) 中 的一种
     * 准确来说是 已插入硬币状态 -摇杆-> 10 抽 1 特奖状态
     *                      -   -> 售出状态
     *
     *               售出状态 -   -> 售罄状态 [售罄状态 不与 已插入硬币状态 直接跳转 而是 间接通过 售出状态 跳转]
     *                      也就是 此时需要修改的状态跳转逻辑 在 HasQuarteerState
     * </pre>
     */
    public void turnCrank() {
        state.turnCrank();
        // 这里可以再优化下 —— 当 turnCrank 没有插入 25 美分 时 不应调用 dispense
        state.dispense();   // dispense 是一个状态内部动作，并不是一个开放给 用户 的 公开动作
    }

    // 6.状态机内部动作
    public void releaseBall() {
        System.out.println("A gumball rolling out the slot...");
        if (count != 0) {
            count -= 1;
        }
    }

    public int getCount() {
        return count;
    }

    @Override
    public String toString() {
        return "GumballMachine{" +
                "state=" + state +
                ", count=" + count +
                '}';
    }

    public GumballMachineState getWinnerState() {
        return winnerState;
    }
}
