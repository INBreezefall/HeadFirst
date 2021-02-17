package DecoratorPattern._5_custom.decorator.subclass.coffee;

import DecoratorPattern._5_custom.decorator.Coffee;

public class HouseBlend extends Coffee {

    public HouseBlend() {
        description = "House Blend Coffee";
    }

    @Override
    public double cost() {
        return .89;
    }
}
