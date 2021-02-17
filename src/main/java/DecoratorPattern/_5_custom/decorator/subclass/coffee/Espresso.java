package DecoratorPattern._5_custom.decorator.subclass.coffee;


import DecoratorPattern._5_custom.decorator.Coffee;

public class Espresso extends Coffee {

    public Espresso() {
        description = "Espresso";
    }

    @Override
    public double cost() {
        return 1.99;
    }
}
