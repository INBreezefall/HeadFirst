package StrategyMode.homework.behavior;

@SuppressWarnings("unused")
public class BowAndArrowBehavior implements WeaponBehavior{
    @Override
    public void fight() {
        System.out.println("弓箭！咻咻咻");
    }
}
