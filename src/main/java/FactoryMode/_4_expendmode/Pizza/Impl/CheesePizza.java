package FactoryMode._4_expendmode.Pizza.Impl;

import FactoryMode._4_expendmode.Pizza.Ingredient.Factory.PizzaIngredientFactory;
import FactoryMode._4_expendmode.Pizza.Pizza;

/**
 * 这里的一个小进步 -- Pizza 类的重构
 * greet eg 中 对于 Pizza 是按照 区域 进行划分的
 * 但究其根本 仍然是 相同的 主料，故可 按照 主料 进行一级分类
 * 区域 作为 IngredientFactory 在 构造器中 传入
 * 传入时机 在 各个地区 PizzaStroe.createPizza 方法中 传入各个地区 IngredientFactory
 */
public class CheesePizza extends Pizza {
    // 这里即是所谓的 组合·成员变量 [感觉这个变量 可以扔到抽象基类中 构造器直接继承下来 这里就不用写了]
    PizzaIngredientFactory pizzaIngredientFactory;

    public CheesePizza(PizzaIngredientFactory pizzaIngredientFactory) {
        this.pizzaIngredientFactory = pizzaIngredientFactory;
    }

    @Override
    public void prepare() {
        System.out.println("Preparing " + name);
        dough = pizzaIngredientFactory.createDough();
        sauce = pizzaIngredientFactory.createSauce();
        cheese = pizzaIngredientFactory.createCheese();
    }
}
