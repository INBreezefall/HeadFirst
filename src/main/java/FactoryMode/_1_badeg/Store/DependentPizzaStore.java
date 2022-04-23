package FactoryMode._1_badeg.Store;

import FactoryMode._1_badeg.Pizza.Pizza;
import FactoryMode._1_badeg.Pizza.subClass.*;

/**
 * 现象: DependentPizzaStore 强依赖的披萨店 Import/直接依赖了 8 个 Pizza 子类
 * 为什么 直接 new 不好 呢？
 * 答案: new A, 并且为 A 可选实例属性 进行参数装载 => 产生多个问题
 *      1.多个地方都需要 new A，就会出现 重复代码(不变的代码)
 *      2.不是自己而是别人写的类 也想要但是不是立刻，而是在需要的时候 new A
 *          甚至于 可能 new A的替代物A1,A2,A3 那么这个时候 new A,A1,A2,A3 硬嵌入代码里 就会显得非常臃肿恶心
 *      3.一旦一个类的 new 过程 发生变化，那么这将会 修改多处 -- 紧耦合
 *      4.new 过程 真的需要公开吗
 *      5.针对 接口编程时 new 某个具体的实现类 if else 不觉得很烦躁吗 (疯狂重复的 if else)
 *      解决方法: 可以 将 new 过程(new A; a.f1 = xx; a.f2 = xx;) 封装进入一个函数/工厂函数 那就会方便很多
 *      这种形式 也就是 Spring 家族的 IOC 控制翻转 的本质 —— IOC 类的 new 行为 不再由 程序员手动写出来 而是 程序控制
 *
 * 一个误区 -> 这种直接依赖 难道不是必要的吗？作为一个 Java 程序 难道都是 静态类、静态方法吗？
 * 实质上 工厂模式 所强调的 并不是 不 new 对象，而是 与 观察者、装饰者、策略模式 一样
 *     将 变化的部分 与 不变的部分 分离
 *         策略模式侧重的是 函数行为 -- 抽象基类 并不是 想象中的那么好用，因为在于 其 过于复杂 是 一个函数的集合
 *             但抽象基类 == 函数集合里的所有函数 并不是 所有子类 都全部需要，因此 策略模式 诞生
 *             也不能说是 诞生，应该以 一个更在准确的词语 -- 回归本质，函数 是 代码的基本单元，理应围绕 函数 进行分割
 *             会变化的函数 & 不变的函数 -- 这是代码设计的核心
 *             总结: 在不同子类中实现会变化的统一行为函数(函数签名相同) 作为 类的实例属性 (而非 可继承的基类函数)
 *                  进行可选择继承(在构造器中赋值 或 set函数择机赋值)
 *         观察者模式侧重的是 一含多同类型实例属性下的函数调用 -- 数组是一个好东西，可以用于 可动态/按需上下线/改变的 相同类型实例
 *             将 一主多从 这样的一组实体 通过 相互内嵌(相互作为实例成员变量) 达到 松耦合
 *             松耦合 == 主对从数量的增删简单 无需更改代码 && 从对主的更改/增删简单 无需更改代码
 *             总结: 对于具有 相互操作的一主多从关系 对象理应通过 相互作为实例成员变量 达到松耦合状态
 *         装饰者模式侧重的是 不改变原有类的代码情况下，增加新的功能 -- Open Closed Principle
 *             这是 对开闭原则 最直白的诠释(对扩展开放，对修改关闭) 当然上面的模式也有相同的痕迹
 *             装饰者模式针对的主体层级是 类 而不是函数，为 基类 增加 新的函数，增强原始基类
 *             总结: 在 一种 好似穿衣服 或者更加本质的说是 一中心多附属 情况下 应使用 new Affiliate(new Core)
 *                  这种 套娃形式 可以做到 无限拓展/无限套娃
 *         工厂模式侧重的是 new 这一行为的 变与不变 —— 将不变抽离 作为可重复调用的部分
 *              以及 将 new 过程中 默认字段填充 进行自动化
 *              最主要的好处是 在有需要的时候 可以随时简单的 new 一个对象 通过调用一个工厂方法
 *
 * 下面我们将开始 着手 观测到 (new 实例化过程) 变化的方面
 */
@SuppressWarnings("unused")
public class DependentPizzaStore {
    /**
     * 创建 Pizza 实体类 的 实例化过程
     * @param style 地区风格
     * @param type 食材种类
     * @return 披萨
     */
    public Pizza createPizza(String style, String type) {
        Pizza pizza = null;
        if (style.equals("NewYork")) {
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
        }
        else if (style.equals("Chicago")) {
            //noinspection IfCanBeSwitch
            if (type.equals("cheese")) {
                pizza = new ChicagoStyleCheesePizza();
            } else if (type.equals("veggie")) {
                pizza = new ChicagoStyleVeggiePizza();
            } else if (type.equals("clam")) {
                pizza = new ChicagoStyleClamPizza();
            } else if (type.equals("pepperoni")) {
                pizza = new CHicagoStylePepperoniPizza();
            }
        }
        else {
            System.out.println("Error: invalid type of pizza");
            return null;
        }
        assert pizza != null;
        pizza.prepare();
        pizza.bake();
        pizza.cut();
        pizza.box();
        return pizza;
    }
}