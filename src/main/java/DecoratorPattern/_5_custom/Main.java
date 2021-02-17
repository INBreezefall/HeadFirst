package DecoratorPattern._5_custom;

import DecoratorPattern._5_custom.decorator.Beverage;
import DecoratorPattern._5_custom.decorator.subclass.coffee.Espresso;
import DecoratorPattern._5_custom.decorator.subclass.condiment.Mocha;

public class Main {
    public static void main(String[] args) {
        Beverage beverage = new Espresso();

        // 纯 Espresso
        System.out.println(beverage.getDescription() + " $" + beverage.cost());

        // 加 2个摩卡
        Beverage beverage2 = new Mocha(beverage);
        beverage2 = new Mocha(beverage2);
        System.out.println(beverage2.getDescription() + " $" + beverage2.cost());
    }
}
