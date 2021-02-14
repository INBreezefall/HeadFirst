package StrategyMode.greateg.behavior.impl.fly;

import StrategyMode.greateg.behavior.FlyBehavior;

public class FlyNoWay implements FlyBehavior {
    @Override
    public void fly() {
        System.out.println("... can't fly ...");
    }
}
