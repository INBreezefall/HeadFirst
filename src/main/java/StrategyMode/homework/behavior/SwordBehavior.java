package StrategyMode.homework.behavior;

@SuppressWarnings("unused")
public class SwordBehavior implements WeaponBehavior{
    @Override
    public void fight() {
        System.out.println("剑来！唰唰唰");
    }
}
