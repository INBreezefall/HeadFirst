package CommandPattern._2_greateg.command;

import CommandPattern._1_badeg.homeApp.Light;

/**
 * 将 Control 遥控器类的耦合性 解耦到 各个家用电器 的 实现了 Command 的 中间层类中
 * 这个地方 不一定是专属的、1-1 关系 因为 Command 类 还可以是 一套家电的组合命令
 */
public class LightOnCommand implements Command {
    private final Light light;

    /**
     * 注意: Light 类 是 外部厂商提供的类 你不能修改它的源代码 !!!
     * @param light 灯主体(外部类)
     */
    public LightOnCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.on();
    }

    @Override
    public void undo() {
        light.off();
    }
}
