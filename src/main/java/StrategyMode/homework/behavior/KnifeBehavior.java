package StrategyMode.homework.behavior;

@SuppressWarnings("unused")
public class KnifeBehavior implements WeaponBehavior{
    @Override
    public void fight() {
        System.out.println("匕首！撕拉撕拉");
    }
}
