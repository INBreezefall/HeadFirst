package StrategyMode.greateg.behavior.impl.quack;

import StrategyMode.greateg.behavior.QuackBehavior;

public class MuteQuack implements QuackBehavior {
    @Override
    public void quack() {
        System.out.println("... can't quack ...");
    }
}
