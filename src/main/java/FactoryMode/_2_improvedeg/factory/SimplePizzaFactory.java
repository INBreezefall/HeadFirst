package FactoryMode._2_improvedeg.factory;

import FactoryMode._1_badeg.Pizza.Pizza;
import FactoryMode._1_badeg.Pizza.subClass.*;

/**
 * 这样做迈出了变好的第一步，但并不足够好 问题只解决了 重复实例化代码，所以 这也不是 真正的工厂模式
 * 讨论 1: 这里也可以全是 static 静态方法 -- 也称为静态简单工厂
 *          但需要注意的缺点是 static 静态方法 无法被继承 及 覆盖修改
 *
 * 注: 面向接口编程，不仅狭隘于 class a implements Interface
 *      而还可以是 实现 抽象类的某个抽象方法
 */
@SuppressWarnings("DuplicatedCode")
public class SimplePizzaFactory {

    /**
     * 这个类的这些函数存在一个问题 -- 他虽然消除了重复代码，但它也限制了代码的灵活性
     * 如果 各个 PizzaStore 想在 create 过程中 增加一些 自己独有的秘诀
     * 那么 这个方法 作为 通用方法 就不再适合了，通用 == 严格限制了变化
     * 我们应该 允许 子类做决定(父类 PizzaStore 定义 抽象工厂方法 createPizza 由子类实现)
     * @param style 地区风格
     * @param type 材料类型
     * @return 披萨
     */
    public Pizza createPizza(String style, String type) {
        Pizza pizza;
        if (style.equals("NewYork")) {
            pizza = createNowYorkPizza(type);
        }
        else if (style.equals("Chicago")) {
            pizza = createChicagoPizza(type);
        }
        else {
            System.out.println("Error: invalid type of pizza");
            return null;
        }
        return pizza;
    }
    /**
     * 返回 纽约地区 披萨
     * @param type 材料类型
     * @return 披萨实例
     */
    public Pizza createNowYorkPizza(String type) {
        Pizza pizza = null;
        switch (type) {
            case "cheese":
                pizza = new NYStyleCheesePizza();
                break;
            case "veggie":
                pizza = new NYStyleVeggiePizza();
                break;
            case "clam":
                pizza = new NYStyleClamPizaa();
                break;
            case "pepperoni":
                pizza = new NYStylePepperoniPizza();
                break;
        }
        return pizza;
    }

    /**
     * 故意用 if 写的，感受下 If else 密麻爆炸
     * @param type 材料类型
     * @return 披萨实例
     */
    @SuppressWarnings("IfCanBeSwitch")
    public Pizza createChicagoPizza(String type) {
        Pizza pizza = null;
        if (type.equals("cheese")) {
            pizza = new ChicagoStyleCheesePizza();
        } else if (type.equals("veggie")) {
            pizza = new ChicagoStyleVeggiePizza();
        } else if (type.equals("clam")) {
            pizza = new ChicagoStyleClamPizza();
        } else if (type.equals("pepperoni")) {
            pizza = new CHicagoStylePepperoniPizza();
        }
        return pizza;
    }
}
