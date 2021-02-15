package StrategyMode.homework.Role;

import StrategyMode.homework.behavior.WeaponBehavior;

@SuppressWarnings("unused")
public abstract class Character {
    protected WeaponBehavior weapon;

    public void setWeaponBehavior(WeaponBehavior w) {
        this.weapon = w;
    }

    public void fight() {
        weapon.fight();
    }
}
