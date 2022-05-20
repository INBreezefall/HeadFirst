package CommandPattern._2_greateg.command;

import CommandPattern._1_badeg.homeApp.CeilingFan;

public class CeilingFanHighCommand implements Command {
    private final CeilingFan ceilingFan;
    private int previousSpeed;

    public CeilingFanHighCommand(CeilingFan ceilingFan) {
        this.ceilingFan = ceilingFan;
    }

    @Override
    public void execute() {
        previousSpeed = ceilingFan.getSpeed();
        ceilingFan.setSpeed(getCurrentSpeed());
    }

    @Override
    public void undo() {
        ceilingFan.setSpeed(previousSpeed);
    }

    /**
     * 一开始想的是 复写 父类成员变量，但实质上 Java 并没有提供这样的语法
     * 父类与子类同名实例变量均会同时存在 通过 this super 来区分
     *
     * 转而通过函数复写来实现，这样也就不用写多余的属性及方法
     * @return 当前类的速度等级
     */
    public int getCurrentSpeed() {
        return CeilingFan.HIGH;
    }
}
