package StrategyMode.greateg.duck.impl;

import StrategyMode.greateg.duck.Duck;
import StrategyMode.greateg.behavior.impl.fly.FlyNoWay;
import StrategyMode.greateg.behavior.impl.quack.MuteQuack;

public class ModelDuck extends Duck {
    @Override
    public void display() {

    }

    public ModelDuck() {
        flyBehavior = new FlyNoWay();
        quackBehavior = new MuteQuack();
    }
}
