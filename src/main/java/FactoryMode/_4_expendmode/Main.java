package FactoryMode._4_expendmode;


import FactoryMode._4_expendmode.Pizza.Pizza;
import FactoryMode._4_expendmode.store.PizzaStore;
import FactoryMode._4_expendmode.store.impl.NYPizzaStore;

/**
 *
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("Someone 向 纽约披萨店 订购 一个 clam 口味披萨");
        PizzaStore nyPizzaStore = new NYPizzaStore();
        Pizza pizza = nyPizzaStore.orderPizza("clam");
        System.out.println(pizza);
    }
}
