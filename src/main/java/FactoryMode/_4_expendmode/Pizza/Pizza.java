package FactoryMode._4_expendmode.Pizza;

import FactoryMode._4_expendmode.Pizza.Ingredient.Ingredients.Cheeses.Cheese;
import FactoryMode._4_expendmode.Pizza.Ingredient.Ingredients.Clamss.Clams;
import FactoryMode._4_expendmode.Pizza.Ingredient.Ingredients.Doughs.Dough;
import FactoryMode._4_expendmode.Pizza.Ingredient.Ingredients.Pepperonis.Pepperoni;
import FactoryMode._4_expendmode.Pizza.Ingredient.Ingredients.Sauces.Sauce;
import FactoryMode._4_expendmode.Pizza.Ingredient.Ingredients.Veggiess.Veggies;

public abstract class Pizza {
    protected String name;

    protected Dough dough;
    protected Sauce sauce;
    protected Veggies[] veggies;
    protected Cheese cheese;
    protected Pepperoni pepperoni;
    protected  Clams clam;

    public void setName(String name) {
        this.name = name;
    }

    // 改变点 prepare 方法 被子类实现
    // 需要重点强调: prepare 是在 createPizza 之后 (一开始创建出的 Pizza 含义仅是 空壳)
    // 即 PizzaStore.createPizza 生成后 再调用 Pizza.prepare

    // 与工厂模式相同的作用: Pizza.prepare() = 新 creator 创造者系
    // dough\sauce\cheese\clam\veggies\pepperoni = 新 product 产品系
    // 将 Pizza 子类中 prepare 方法 与 原料家族的具体子类 解耦
    // = 在 Pizza 子类中 prepare 方法 中 不会看到 原料家族的具体子类的引用 import 只有 原料家族的基类
    abstract public void prepare();

    public void bake() {
    }

    public void cut() {
    }

    public void box() {
    }
}
