package DecoratorPattern._1_badeg;

/**
 * -- 1.开闭原则
 * 利用继承设计子类行为，是在编译期静态决定的，而且所有子类将会继承到相同的行为
 * 如果能利用组合的做法扩展对象的行为，就可以在运行时动态地进行扩展
 *
 * 代码应免于改变，而又易于扩展 —— 最重要的设计原则 1 类应该对扩展开放，对修改关闭 [开闭原则]
 *    仍是在讲，将变化与不变隔离开来，这样易于 变化的扩展，而不变的则仍然不变
 *
 * 缺点：这样的设计通常会耗费大量时间与精力，遵循开闭原则通常会 引入 新的抽象层次(抽象类、接口) 增加代码复杂度
 *          你需要权衡 哪块代码更加重要 更加容易改变 更加适合 采用 开闭原则 [这通常需要你具备一定实践经验]
 * 注意 不要 每个地方都采用 开闭原则，没有浪费这么多时间的必要，且 代码会变得复杂难以理解
 *
 * -- 2.类爆炸
 * 饮料，根据各种组合加料产生 更多的子类 导致 子类继承爆炸，大量实现覆写，诞生 “维护噩梦”
 *      一种 加料 价格修改 导致 大量关联子类修改
 */
public abstract class Beverage {
    private String description;

    public String getDescription() {
        return description;
    }

    public abstract float cost();
}