package FactoryMode._3_greateg;

import FactoryMode._3_greateg.pizza.Pizza;
import FactoryMode._3_greateg.store.PizzaStore;
import FactoryMode._3_greateg.store.impl.ChicagoPizzaStore;
import FactoryMode._3_greateg.store.impl.NYPizzaStore;

/**
 * 这里就突显出了 2个 系统性概念
 * Creator 创建者系
 * Product 产品系
 *
 * 创建者系 = 实现了 创建对象接口 的 实现子类
 * 创建对象接口的返回值/对象 = 产品系 的 实现子类
 *
 * 工厂方法 最大价值在于 将 产品系的实例化 从 创建者超类 转移到了 创建者子类中
 * 并且 在 具有 子类实现灵活性的同时 还具有 超类的限制性(create 方法只是流程(orderPizza)的一部分)
 * 将 可能变化的 new 过程 分离到了子类中，让 子类 自己决定 如何 new、怎么 new、new 什么
 * 将 一个超类的复杂性 分散到了 一堆子类中 自己管理自己的复杂性 == 联邦 Federation / 州自治
 * 超类 无需关注 create 工厂方法 到底是以什么逻辑创建了个什么 Product，只要知道 出来的是个 Product 就行了
 * Product 抽象 屏蔽了 底层具体实现
 *
 * 第二价值在于，工厂方法 将 具体的实现类 import 从 高层抽象(PizzaStore) 中 转移到了 具体子类中(NYPS,CPS)
 * 让 高层抽象 PizzaStore 仅与 产品系高层抽象 Pizza 进行互动
 */
public class Main {
    public static void main(String[] args) {
        PizzaStore nyPizzaStore = new NYPizzaStore();
        ChicagoPizzaStore chicagoPizzaStore = new ChicagoPizzaStore();

        System.out.println("Someone 向 纽约披萨店 订购 一个 cheese 口味披萨");
        Pizza nyPizza = nyPizzaStore.orderPizza("cheese");
        System.out.println(nyPizza.getClass());

        System.out.println("Someone 向 芝加哥披萨店 订购 一个 cheese 口味披萨");
        Pizza cPizza = chicagoPizzaStore.orderPizza("cheese");
        System.out.println(cPizza.getClass());
    }
}
