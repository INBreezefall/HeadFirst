package CommandPattern._2_greateg.command;

/**
 * Command 可以直译为 命令
 * 但也可以 泛化为 请求/需求
 *
 * Command 是一个接口、是一个行为、是一种特征
 * 接口 并不是一个 全面性的类 视角，而是一个 部分性的行为 视角
 *
 * Command 接口 将 "请求/命令" 丰富为了 一个实例对象，作为参数传入函数
 * 但 需要注意的是 这并不是丰富为了 一个笨重的类 及其 类继承体系
 * 仅仅是 将各个 实例对象 暴露一个 方法 void execute()
 * 至于 各个实例对象 execute() 内部是如何实现的 外界函数完全不知 且 无需知道
 *
 * 外界函数 = 遥控器 无需关心 Command 对象到底是什么 Class
 * 只要 这个 Class 实现了 Command.execute() 即可
 *
 * 命令模式类结构
 *                              Command(Interface)
 * Invoke        ConcreteCommand_1\ConcreteCommand_2\ConcreteCommand_3(Class)         TrueCommandReceiver
 *
 * 简单来看，即是 中间层解耦 (通过 Interface 将 TrueCommandReceiver 与 Command 对象 进行 n 对 1 关系)
 *
 * 注意 这里的 On Off 比较简单，如果要实现 undo() 那么就不能 写 on && off && undo 了 [因为 接口 不能定义实例变量 只能定义实例方法]
 * 只能写 execute() && undo()
 */
public interface Command {
    void execute();
    void undo();

    // 如果考虑将 状态保存至各个 Command 中间层中，那么就会导致所有 Command 中间层的复杂化(都要创建一个状态变量)
    // 为何会考虑 将状态 存储至 Command 中间层 —— 因为 风扇 Fan 类 存在多个档级状态，这样的话就可以只写一个 FanCommand 类
    // 现在这个模式 需要写 四个档级 各自均有一个 FanCommand 类 与 电灯 Light 一致，一个状态一个 Command
    // void getPreviousState();
}
