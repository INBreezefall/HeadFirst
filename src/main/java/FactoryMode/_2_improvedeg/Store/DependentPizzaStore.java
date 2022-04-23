package FactoryMode._2_improvedeg.Store;

import FactoryMode._1_badeg.Pizza.Pizza;
import FactoryMode._2_improvedeg.factory.SimplePizzaFactory;

@SuppressWarnings("unused")
public class DependentPizzaStore {
    // 改进点 1: 抽出 Pizza 代码为 单独的类，从 代码耦合 改为了 类与类的组和关系
    SimplePizzaFactory factory;

    public DependentPizzaStore(SimplePizzaFactory factory) {
        this.factory = factory;
    }

    /**
     * 将创建 Pizza 实体类 的 实例化过程 委托给了 SimplePizzaFactory 类
     * 实际上 这并不是 工厂模式，但可以说是 一个雏形，一个开始 将重复代码进行抽取单独放置的 开始
     * 这一下子就清爽太多了 美滋滋
     * @param style 地区风格
     * @param type 食材种类
     * @return 披萨
     */
    public Pizza createPizza(String style, String type) {
        Pizza pizza = factory.createPizza(style, type);
        assert pizza != null;
        pizza.prepare();
        pizza.bake();
        pizza.cut();
        pizza.box();
        return pizza;
    }
}