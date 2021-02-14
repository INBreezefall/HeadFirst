package StrategyMode.greateg.behavior.impl.quack;

import StrategyMode.greateg.behavior.QuackBehavior;

public class Quack implements QuackBehavior {
    @Override
    public void quack() {
        System.out.println("！呱呱！");
    }
}
