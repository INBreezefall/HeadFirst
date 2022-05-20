package CommandPattern._2_greateg.controller;

import CommandPattern._2_greateg.command.Command;

public class SimpleRemoteControl {
    // 实现了 Command 接口的 家用电器 实例
    Command slot;

    public SimpleRemoteControl() {}

    /**
     * 可动态设置 插槽中的命令 | 如果不需要动态 则直接扔进 构造器参数即可 or 实例变量直接写死类型
     * @param command 插槽控制的家用电器
     */
    public void setCommand(Command command) {
        slot = command;
    }

    public void buttonWashPressed() {
        slot.execute();
    }
}
