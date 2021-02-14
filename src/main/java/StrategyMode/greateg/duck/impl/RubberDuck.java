package StrategyMode.greateg.duck.impl;

import StrategyMode.greateg.behavior.impl.fly.FlyNoWay;
import StrategyMode.greateg.behavior.impl.quack.Squeak;
import StrategyMode.greateg.duck.Duck;

public class RubberDuck extends Duck {

    public RubberDuck() {
        flyBehavior = new FlyNoWay();
        quackBehavior = new Squeak();
    }

    @Override
    public void display() {

    }
}


