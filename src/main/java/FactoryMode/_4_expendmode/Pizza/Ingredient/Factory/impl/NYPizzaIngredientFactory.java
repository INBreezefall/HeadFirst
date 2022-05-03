package FactoryMode._4_expendmode.Pizza.Ingredient.Factory.impl;

import FactoryMode._4_expendmode.Pizza.Ingredient.Ingredients.Cheeses.Cheese;
import FactoryMode._4_expendmode.Pizza.Ingredient.Ingredients.Cheeses.ReggianoCheese;
import FactoryMode._4_expendmode.Pizza.Ingredient.Ingredients.Clamss.Clams;
import FactoryMode._4_expendmode.Pizza.Ingredient.Ingredients.Clamss.FreshClams;
import FactoryMode._4_expendmode.Pizza.Ingredient.Ingredients.Doughs.Dough;
import FactoryMode._4_expendmode.Pizza.Ingredient.Factory.PizzaIngredientFactory;
import FactoryMode._4_expendmode.Pizza.Ingredient.Ingredients.Doughs.ThinCrustDough;
import FactoryMode._4_expendmode.Pizza.Ingredient.Ingredients.Pepperonis.Pepperoni;
import FactoryMode._4_expendmode.Pizza.Ingredient.Ingredients.Pepperonis.SlicedPepperonis;
import FactoryMode._4_expendmode.Pizza.Ingredient.Ingredients.Sauces.MarinaraSauce;
import FactoryMode._4_expendmode.Pizza.Ingredient.Ingredients.Sauces.Sauce;
import FactoryMode._4_expendmode.Pizza.Ingredient.Ingredients.Veggiess.*;

public class NYPizzaIngredientFactory implements PizzaIngredientFactory {
    @Override
    public Dough createDough() {
        return new ThinCrustDough();
    }

    @Override
    public Sauce createSauce() {
        return new MarinaraSauce();
    }

    @Override
    public Cheese createCheese() {
        return new ReggianoCheese();
    }

    @Override
    public Veggies[] createVeggies() {
        return new Veggies[] {new Garlic(), new Onion(), new Mushroom(), new RedPepper()};
    }

    @Override
    public Pepperoni createPepperoni() {
        return new SlicedPepperonis();
    }

    @Override
    public Clams createClam() {
        return new FreshClams();
    }
}
