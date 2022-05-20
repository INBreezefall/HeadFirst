package CommandPattern._1_badeg;

import CommandPattern._1_badeg.homeApp.HotTub;
import CommandPattern._1_badeg.homeApp.Light;

/**
 * 中央控制器 现实长相
 * 共有 7 个插槽 和 7 对 on off 按钮
 * 插槽1 on off
 * 插槽2 on off
 * 插槽3 on off
 * 插槽4 on off
 * 插槽5 on off
 * 插槽6 on off
 * 插槽7 on off
 *
 * 一个 插槽对应 一个 家居 HomeApp
 * 例如
 * 插槽1 = 电灯, on = 开灯, off = 关灯
 * 插槽2 = 浴缸, on = 放水, off = 关水
 * ...
 */
public class CentralControl {
    private String slot_1;
    private Light light;
    private HotTub hotTub;

    /**
     * 恐怖的 if else 爆炸
     * 每新增一个 家电 就要修改所有的 slot_1234567 on off 函数，实在太恐怖了
     */
    public void slot_1_on() {
        if ("Light".equals(slot_1)) {
            light.on();
        } else if ("HotTub".equals(slot_1)) {
            hotTub.jetsOn();
        }
    }
    public void slot_1_off() {}
    public void slot_2_on() {}
    public void slot_2_off() {}
    public void slot_3_on() {}
    public void slot_3_off() {}
    public void slot_4_on() {}
    public void slot_4_off() {}
    public void slot_5_on() {}
    public void slot_5_off() {}
    public void slot_6_on() {}
    public void slot_6_off() {}
    public void slot_7_on() {}
    public void slot_7_off() {}
}
