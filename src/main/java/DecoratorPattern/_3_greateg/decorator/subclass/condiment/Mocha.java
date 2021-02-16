package DecoratorPattern._3_greateg.decorator.subclass.condiment;

import DecoratorPattern._3_greateg.decorator.Beverage;
import DecoratorPattern._3_greateg.decorator.CondimentDecorator;

public class Mocha extends CondimentDecorator {

    public Mocha(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public double cost() {
        return .20 + beverage.cost();
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + ", Mocha";
    }
}
