package FactoryMode._4_expendmode.Pizza.Ingredient.Factory;

import FactoryMode._4_expendmode.Pizza.Ingredient.Ingredients.Cheeses.Cheese;
import FactoryMode._4_expendmode.Pizza.Ingredient.Ingredients.Clamss.Clams;
import FactoryMode._4_expendmode.Pizza.Ingredient.Ingredients.Doughs.Dough;
import FactoryMode._4_expendmode.Pizza.Ingredient.Ingredients.Pepperonis.Pepperoni;
import FactoryMode._4_expendmode.Pizza.Ingredient.Ingredients.Sauces.Sauce;
import FactoryMode._4_expendmode.Pizza.Ingredient.Ingredients.Veggiess.Veggies;

/**
 * Product: 各种原料 Ingredient
 * Creator: 原料工厂 (1 * n 种原料) PizzaIngredientFactory [1 对 n 关系]
 * PizzaIngredientFactory: 原料家族工厂 (高层抽象接口)
 *
 */
public interface PizzaIngredientFactory {
    Dough createDough();
    Sauce createSauce();
    Cheese createCheese();
    Veggies[] createVeggies();
    Pepperoni createPepperoni();
    Clams createClam();
}
