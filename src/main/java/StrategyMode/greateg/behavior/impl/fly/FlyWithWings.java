package StrategyMode.greateg.behavior.impl.fly;

import StrategyMode.greateg.behavior.FlyBehavior;

public class FlyWithWings implements FlyBehavior {
    @Override
    public void fly() {
        System.out.println("！芜湖 起飞！");
    }
}
