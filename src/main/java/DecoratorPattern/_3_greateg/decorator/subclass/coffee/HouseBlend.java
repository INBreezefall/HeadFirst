package DecoratorPattern._3_greateg.decorator.subclass.coffee;

import DecoratorPattern._3_greateg.decorator.Beverage;

public class HouseBlend extends Beverage {

    public HouseBlend() {
        description = "House Blend Coffee";
    }

    @Override
    public double cost() {
        return .89;
    }
}
