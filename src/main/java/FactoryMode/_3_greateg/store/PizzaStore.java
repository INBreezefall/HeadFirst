package FactoryMode._3_greateg.store;


import FactoryMode._3_greateg.pizza.Pizza;

/**
 * 这里我们将 代码 提升为 可适配多种类型 PizzaStore 并让 createPizza 具有更大的子类可定制性
 *
 * 现象: 这里相较于 bad eg 只直接依赖了 Pizza 一个抽象基类，而不是 8个 Pizza 子类
 * => 引入原则: 依赖倒置原则 Dependency Inversion Principe [除了吹牛装逼 也想不到什么好处了]
 *      依赖 抽象，而不是依赖 具体实现类 | 针对 接口 编程，而不是针对 实现 编程
 *      不应让 高层抽象组件(PizzaStore) 依赖 底层实现类组件(XXX_Pizza) 而是也应该依赖 高层抽象(Pizza)
 * 对于思考的改变/倒置
 *      不应该 先从具体实现类如何实现 进行思考，而是先将 整个事情中的 关键抽象 摘出
 *      先定义 抽象类，并实现 高层抽象(PizzaStore & Pizza) 间的调用活动，然后再对 抽象类的子类 进行实现
 *
 * 如果让羊在外面乱跑，我们就无法收集到羊毛 —— 这个比喻很形象
 */
public abstract class PizzaStore {

    /**
     * 到了这一步 其实我们可以看出 工厂模式 可以更加精确的描述为 工厂方法
     *     或者说是 真正 工厂思想 = 抽取 new 过程为抽象方法 + 继承子类覆写
     *             简单 工厂方法 = 抽取重复代码 + 委托组合
     *     二者区别: 工厂思想 是个框架 在 Main 类会体现，
     *          而 简单工厂方法 则仅是个 委托组合 不具备弹性，无法对未来的改变具有扩展能力
     *     需要注意的是: 真正工厂思想 也无需 都是 abstract
     *         如果仅有 一个默认方法 就可以满足需求 那也没什么问题
     *
     *     protected 权限 => 修饰 不想被外界/非本类调用 但又想继承给子类 的 方法
     *
     * 工厂方法 = protected abstract Product factoryMethod(T params);
     *      专门用于处理 类创建事务的函数
     * @return 披萨
     */
    protected abstract Pizza createPizza(String type);

    public Pizza orderPizza(String type) {
        Pizza pizza = createPizza(type);
        pizza.prepare();
        pizza.bake();
        pizza.cut();
        pizza.box();
        return pizza;
    }
}
