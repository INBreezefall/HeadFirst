package DecoratorPattern._2_promote;

/**
 * 这样的改进 虽然在 父类实现了 cost 方法，子类无需覆写，但仍无法处理
 *  1.加料变化 仍然要修改 基类
 *  2.类数量爆炸
 *  3.设计死板
 *  4.基类的函数并不适用于 全部子类
 */
public abstract class Beverage {
    private String description;
    private boolean milk;
    private boolean soy;
    private boolean mocha;
    private boolean whip;

    public String getDescription() {
        return description;
    }

    protected float cost() {
        float cost = 0;
        if (hasMilk())
            cost += 0;
        return cost;
    }

    public boolean hasMilk() {
        return milk;
    }

    public void setMilk(boolean milk) {
        this.milk = milk;
    }

    public boolean hasSoy() {
        return soy;
    }

    public void setSoy(boolean soy) {
        this.soy = soy;
    }

    public boolean hasMocha() {
        return mocha;
    }

    public void setMocha(boolean mocha) {
        this.mocha = mocha;
    }

    public boolean hasWhip() {
        return whip;
    }

    public void setWhip(boolean whip) {
        this.whip = whip;
    }
}
