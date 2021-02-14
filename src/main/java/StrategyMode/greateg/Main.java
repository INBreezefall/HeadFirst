package StrategyMode.greateg;

import StrategyMode.greateg.behavior.impl.fly.FlyWithWings;
import StrategyMode.greateg.duck.Duck;
import StrategyMode.greateg.duck.impl.ModelDuck;
import StrategyMode.greateg.duck.impl.RubberDuck;

/**
 *                Duck              -->                FlyBehavior [一族算法]
 *      /        /    \      \                          /       \
 *    Mallard Redhead Rubber Decoy              FlyWithWings  FlyNoWay
 *
 *                                 -->                QuackBehavior [一族算法]
 *                                                  /     |      \
 *                                              Quack  Squeak  MuteQuack [可相互替代]
 */
@SuppressWarnings("unused")
public class Main {
    public static void main(String[] args) {
        dynamicTest();
    }

    public static void simplyTest() {
        Duck rubberDuck = new RubberDuck();
        rubberDuck.performFly();
        rubberDuck.performQuack();
    }

    public static void dynamicTest() {
        Duck modelDuck = new ModelDuck();
        modelDuck.performFly();
        modelDuck.setFlyBehavior(new FlyWithWings());
        modelDuck.performFly();
    }
}
