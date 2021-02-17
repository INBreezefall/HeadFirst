package DecoratorPattern._3_greateg;

import DecoratorPattern._3_greateg.decorator.Beverage;
import DecoratorPattern._3_greateg.decorator.subclass.coffee.Espresso;
import DecoratorPattern._3_greateg.decorator.subclass.condiment.Mocha;

/**
 * 装饰者模式
 * 1.装饰者 与 被装饰者 是 相同超类型(接口)
 * 2.允许 一个或多个装饰者 装饰 一个对象
 * 3.装饰过后的 原始对象(原始被装饰者) 可被 任意 装饰对象 代替 [相同超类型]
 * 4.装饰者 可控制 调用被装饰者行为 之前、之后 加上 装饰者本身的行为
 *
 * 使用场景中 常与 工厂模式 && 生成器模式 一共使用
 *
 * 关于 Espresso, Mocha, Mocha $2.39 可在最后追加 一个 末端装饰者 CondimentPrettyPrint
 *      针对 复数个 调料 进行 输出美化
 *
 *      核心
 *          1.将 同抽象父类对象 作为 构造器参数 传入 并保存至 被装饰实例变量
 *          2.链式计算 方法 如 此例的 cost(){ self.value + 被装饰实例变量.value }
 *
 *          原始被装饰实例 + 被装饰实例1 + 被装饰实例2 + ... + 被装饰实例n (+ 末端装饰实例)
 *
 *          优点：将 咖啡主体 与 调味品客体及配套特定行为 相互分隔/抽象开来 但仍然具有共同抽象父类
 *          缺点：必须管理好更多的子类 [通常与工厂模式一同使用]
 *          实质：剥离 同一个主体类的 多种特征
 *          变化的根源：这些特征 任意组合 出现在 该主体类的实例之中
 *
 *                          (装饰者与被装饰者)共同抽象超类(接口/抽象类) A
 *                          /          实现 or 继承关系        \           A&B 可以是同一个抽象父类
 *       (包含被装饰者实例)装饰者(抽象父类) C             被装饰者/组件(主体类/抽象父类) B
 *                  /           \
 *               装饰者1        装饰者2
 *
 * JDK 装饰者使用 简直 排山倒海 Java I/O
 */
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
