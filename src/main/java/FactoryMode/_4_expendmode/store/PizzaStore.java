package FactoryMode._4_expendmode.store;


import FactoryMode._4_expendmode.Pizza.Pizza;

public abstract class PizzaStore {
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
