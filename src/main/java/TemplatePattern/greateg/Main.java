package TemplatePattern.greateg;

import TemplatePattern.badeg.CoffeeWithHook;
import TemplatePattern.greateg.subclass.Coffee;
import TemplatePattern.greateg.subclass.Tea;

public class Main {
    public static void main(String[] args) {
        Tea tea = new Tea();
        System.out.println("\nMaking tea...");
        tea.prepareRecipe();

        Coffee coffee = new Coffee();
        System.out.println("\nMaking coffee...");
        coffee.prepareRecipe();

        CoffeeWithHook coffeeHook = new CoffeeWithHook();
        System.out.println("\nMaking coffeeHook...");
        coffeeHook.prepareRecipe();
    }
}
