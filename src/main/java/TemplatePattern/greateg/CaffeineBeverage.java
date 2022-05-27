package TemplatePattern.greateg;

/**
 * badeg 可以很明显的观察到 二者十分类似，具有相同过程 prepareRecipe，可抽象出一个 共同父类 即 咖啡因饮料
 * 这个模式没啥好说的，就是重复代码的抽象重构，不过需要点出来
 *
 * 1.地方主导性：badeg 由 Coffee 及 Tea 自身 作为主导 由 它们自己定义的代码决定整个 prepareRecipe 过程
 * 2.中央集权：greateg 的 prepareRecipe 过程 则由 抽象父类定义 CaffeineBeverage，控制权 归拢一处 进行 "中央集权"
 *      好处：prepareRecipe 抽象过程 与 brew/addCondiments 子类具体实现 相分离 无强耦合
 *          子类对于 公共代码 CaffeineBeverage 复用最大化
 *          prepareRecipe 算法过程 由 CaffeineBeverage 主导并唯一控制
 * 3.算法骨架 及 部分步骤的子类延迟实现/重新定义
 * 4.钩子 hook & 条件 condition
 *      可通过覆写 condition 来控制 抽象父类 算法骨架执行逻辑 -- 是否执行 hook 方法
 *      有好几种用途
 *      ①实现 算法骨架中可选的逻辑部分
 *          在本例中 可以 通过覆写 condition 以 命令行输入的形式 来 模拟 顾客意见是否 addCondiments(hook)
 *      ②让子类有能力对模板方法中某些即将发生 or 刚刚发生的步骤 进行 响应 (AOP 切入/响应点的概念)
 *
 */
public abstract class CaffeineBeverage {
    final public void prepareRecipe() {
        boilWater();
        brew();
        pourInCup();
        if (condition()) {
            addCondiments();
            hook();
        }
    }

    protected void hook() {
    }

    protected boolean condition() {
        return true;
    }

    abstract public void addCondiments();

    abstract public void brew();

    final void pourInCup() {
        System.out.println("Pouring into cup");
    }

    final void boilWater() {
        System.out.println("Boiling water");
    }
}
