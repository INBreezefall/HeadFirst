package StatePattern.badeg;

/**
 * 缺点很明显 —— 变化性 / 扩展性 [未将变化的代码封装起来 放在一个独立的地方]
 * 一旦新增一种状态 就得在所有方法中新增 if 判断语句，一旦修改的地方多了，你写出 BUG 的几率也就越多
 * 更不用说 在维护的过程中 远远不止新增 一种状态，甚至是数十种
 */
public class GumballMachine {
    // 1.定义状态常量
    // 售罄
    final static int SOLD_OUT = 0;
    // 没有投入 25 美分
    final static int NO_QUARTER = 1;
    // 已投入 25 美分
    final static int HAS_QUARTER = 2;
    // 售出糖果
    final static int SOLD = 3;

    // 2.定义成员变量
    // 2.1 定义当前状态变量
    int state = SOLD_OUT;
    // 2.2 定义糖果个数变量
    int count;


    // 3.构造器初始化
    public GumballMachine(int count) {
        this.count = count;
        if (count > 0) {
            state = NO_QUARTER;
        }
    }

    // 4.动作
    // 4.1 插入 25 美分动作
    public void insertQuarter() {
        if (state == HAS_QUARTER) {
            System.out.println("You can't insert another quarter");
        } else if (state == NO_QUARTER) {
            state = HAS_QUARTER;                        // 状态更新
            System.out.println("You inserted a quarter");
        } else if (state == SOLD_OUT) {
            System.out.println("You can't insert a quarter, because the machine is sold out");
        } else if (state == SOLD) {
            System.out.println("Please wait, we're giving you a gumball");
        }
    }

    // 4.2 弹出 25 美分动作
    public void ejectQuarter() {
        if (state == HAS_QUARTER) {
            System.out.println("Quarter returned");
            state = NO_QUARTER;                         // 状态更新
        } else if (state == NO_QUARTER) {
            System.out.println("You haven't inserted a quarter");
        } else if (state == SOLD_OUT) {
            System.out.println("You haven't inserted a quarter, because the machine is sold out");
        } else if (state == SOLD) {
            System.out.println("Sorry, you already turned the crank");
        }
    }

    // 4.3 转动曲柄
    public void turnCrank() {
        if (state == HAS_QUARTER) {
            System.out.println("You turned...");
            state = SOLD;                               // 状态更新
            dispense();                                 // 发放糖果
        } else if (state == NO_QUARTER) {
            System.out.println("You turned but there's no quarter");
        } else if (state == SOLD_OUT) {
            System.out.println("You turned but there's no gumballs");
        } else if (state == SOLD) {
            System.out.println("Sorry, you just now turned the crank");
        }
    }

    // 4.4 发放糖果至槽中
    private void dispense() {
        if (state == HAS_QUARTER) {
            System.out.println("This time no gumball should dispensed");
        } else if (state == NO_QUARTER) {
            System.out.println("This time no gumball should dispensed");
        } else if (state == SOLD_OUT) {
            System.out.println("This time no gumball should dispensed");
        } else if (state == SOLD) {
            System.out.println("A gumball comes rolling out the slot");
            count -= 1;
            if (count == 0) {
                state = SOLD_OUT;
            } else {
                state = NO_QUARTER;
            }
        }
    }

    // 5.其他函数

    @Override
    public String toString() {
        return "GumballMachine{" +
                "state=" + state +
                ", count=" + count +
                '}';
    }
}
