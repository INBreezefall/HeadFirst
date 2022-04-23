package FactoryMode._3_greateg.store.impl;

import FactoryMode._3_greateg.pizza.Pizza;
import FactoryMode._3_greateg.pizza.impl.NYStyleCheesePizza;
import FactoryMode._3_greateg.pizza.impl.NYStyleVeggiePizza;
import FactoryMode._3_greateg.store.PizzaStore;

public class NYPizzaStore extends PizzaStore {
    @Override
    public Pizza createPizza(String type) {
        if ("cheese".equals(type)) {
            return new NYStyleCheesePizza();
        } else if ("veggie".equals(type)) {
            return new NYStyleVeggiePizza();
        }
        return null;
    }
}
