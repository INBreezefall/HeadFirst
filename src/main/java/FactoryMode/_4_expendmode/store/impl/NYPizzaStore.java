package FactoryMode._4_expendmode.store.impl;

import FactoryMode._4_expendmode.Pizza.Impl.CheesePizza;
import FactoryMode._4_expendmode.Pizza.Impl.ClamPizza;
import FactoryMode._4_expendmode.Pizza.Ingredient.Factory.PizzaIngredientFactory;
import FactoryMode._4_expendmode.Pizza.Ingredient.Factory.impl.NYPizzaIngredientFactory;
import FactoryMode._4_expendmode.Pizza.Pizza;
import FactoryMode._4_expendmode.store.PizzaStore;

/**
 * 改变了什么呢？
 * ①在 PizzaStore 实现类中 对 Pizza 子类实例对象的构造器中
 *      追加了一个 PizzaIngredientFactory 子类实例对象
 *      用于在 PizzaStore.orderPizza 后续步骤 pizza.prepare 进行 对原料的地区化处理
 * ②将 Pizza 子类 从 4个(clam/cheese 2 * chicago/ny 2) 减少到了 2 个 clam/cheese
 */
public class NYPizzaStore extends PizzaStore {
    @Override
    public Pizza createPizza(String type) {
        FactoryMode._4_expendmode.Pizza.Pizza pizza = null;
        PizzaIngredientFactory NYPIF = new NYPizzaIngredientFactory();

        if ("cheese".equals(type)) {
            pizza = new CheesePizza(NYPIF);
            pizza.setName("New York Style Cheese Pizza");
        } else if ("clam".equals(type)) {
            pizza = new ClamPizza(NYPIF);
            pizza.setName("New York Style Clam Pizza");
        }
        return pizza;
    }
}
