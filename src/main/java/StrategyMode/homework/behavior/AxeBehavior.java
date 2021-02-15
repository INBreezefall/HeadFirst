package StrategyMode.homework.behavior;

@SuppressWarnings("unused")
public class AxeBehavior implements WeaponBehavior{
    @Override
    public void fight() {
        System.out.println("斧子！卡卡卡");
    }
}
