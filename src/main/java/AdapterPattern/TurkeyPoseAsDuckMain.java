package AdapterPattern;

import AdapterPattern.adapter.TurkeyAdapter;
import AdapterPattern.duck.Duck;
import AdapterPattern.duck.MallardDuck;
import AdapterPattern.turkey.WildTurkey;

public class TurkeyPoseAsDuckMain {
    public static void main(String[] args) {
        // 1.创建 一只 鸭子 一只 火鸡
        MallardDuck mallardDuck = new MallardDuck();
        WildTurkey wildTurkey = new WildTurkey();

        // 2.创建 一个适配器 从而令一只火鸡 假冒 一只鸭子
        TurkeyAdapter turkeyAdapter = new TurkeyAdapter(wildTurkey);

        // 3.测试火鸡
        System.out.println("Test Turkey...");
        wildTurkey.gobble();
        wildTurkey.fly();

        // 4.1 测试真鸭子
        System.out.println("\nTest Duck 1...");
        testDuck(mallardDuck);
        // 4.2 测试假冒鸭子的火鸡
        System.out.println("\nTest Duck 2...");
        testDuck(turkeyAdapter);
    }

    static void testDuck(Duck duck) {
        duck.quack();
        duck.fly();
    }
}
