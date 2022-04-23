package FactoryMode._3_greateg.store.impl;

import FactoryMode._3_greateg.pizza.Pizza;
import FactoryMode._3_greateg.pizza.impl.ChicagoStyleCheesePizza;
import FactoryMode._3_greateg.pizza.impl.ChicagoStyleVeggiePizza;
import FactoryMode._3_greateg.store.PizzaStore;

public class ChicagoPizzaStore extends PizzaStore {
    @Override
    protected Pizza createPizza(String type) {
        if ("cheese".equals(type)) {
            return new ChicagoStyleCheesePizza();
        } else if ("veggie".equals(type)) {
            return new ChicagoStyleVeggiePizza();
        }
        return null;
    }
}
