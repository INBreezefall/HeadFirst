package StatePattern.homework;

@SuppressWarnings("DuplicatedCode")
public class Main {
    public static void main(String[] args) {
        // 1.初始化 & 打印糖果机状态
        GumballMachine gumballMachine = new GumballMachine(5);
        System.out.println(gumballMachine);

        // 2.插入 25 美分且转动曲柄 & 打印糖果机状态 [-1]
        gumballMachine.insertQuarter();
        gumballMachine.turnCrank();
        System.out.println(gumballMachine);

        // 3.插入 25 美分且退出 25 美分 & 打印糖果机状态
        gumballMachine.insertQuarter();
        gumballMachine.ejectQuarter();
        System.out.println(gumballMachine);

        // 4.插入 25 美分且转动曲柄 * 2 且 退出 25 美分 & 打印糖果机状态 [-2]
        gumballMachine.insertQuarter();
        gumballMachine.turnCrank();
        gumballMachine.insertQuarter();
        gumballMachine.turnCrank();
        gumballMachine.ejectQuarter();
        System.out.println(gumballMachine);

        // 5.连续插入 2 次 25 美分且转动曲柄 且 插入 25 美分且转动曲柄 * 2 & 打印糖果机状态 [-3]
        gumballMachine.insertQuarter();
        gumballMachine.insertQuarter();
        gumballMachine.turnCrank();
        gumballMachine.insertQuarter();
        gumballMachine.turnCrank();
        System.out.println(gumballMachine);
        System.out.println("--- Hint: no gumballs ---");
        gumballMachine.insertQuarter();
        gumballMachine.turnCrank();
        System.out.println(gumballMachine);

        // 6.装填 糖果机 2 颗
        gumballMachine.refill(2);
        gumballMachine.insertQuarter();
        gumballMachine.turnCrank();
        System.out.println(gumballMachine);
    }
}
