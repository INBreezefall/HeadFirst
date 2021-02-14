package StrategyMode.greateg.duck;

import StrategyMode.greateg.behavior.FlyBehavior;
import StrategyMode.greateg.behavior.QuackBehavior;

/**
 * 将 行为 作为最细粒度的抽象，与 原类中抽取 独立出来
 * 并 将 行为的多种实现 通过 独立类 进行实现，从而既有 继承的优点(代码复用) 又可发挥 接口的存在意义
 * 将 Fly 与 Quack 函数 从 Duck 类中 提取出来，并可进行与 Duck 无关的独立维护，作为子类的一个实例变量
 * 即 有了 继承的好处，又没有 继承的包袱(不适合方法继承的部分子类复写) 不再耦合进入 Duck 子类继承/实现
 * <p>
 * 一切皆对象，包括行为也是一个对象
 */
public abstract class Duck {
    private String name;

    // 面向接口编程 而非面向实现编程 (@Overwrite)
    // 在 Duck 这个抽象类 代码中 不需要关注 FlyBehavior、QuackBehavior 具体实现
    // Duck子类不需要继承 FlyBehavior、QuackBehavior 只需要在 构造时 new各个行为具体实现类即可
    // 解决掉了 子类继承的强耦合性，又保障 行为代码的复用
    protected FlyBehavior flyBehavior;
    protected QuackBehavior quackBehavior;

    // 全子类各自实现函数
    public abstract void display();

    // 全子类共有函数
    public void swim() {
        System.out.println("All ducks float, ");
    }

    // 部分继承实现函数，且独立于Duck子类
    public void performFly() {
        flyBehavior.fly();
    }

    public void performQuack() {
        quackBehavior.quack();
    }

    // 动态改变行为接口的实现类 => 动态设定行为
    // 意义是在于，实现类可能随着时间、环境条件不同 而发生改变
    public void setFlyBehavior(FlyBehavior fb) {
        flyBehavior = fb;
    }

    public void setQuackBehavior(QuackBehavior qb) {
        quackBehavior = qb;
    }

}
