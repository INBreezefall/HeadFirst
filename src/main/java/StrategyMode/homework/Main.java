package StrategyMode.homework;

import StrategyMode.homework.Role.Character;
import StrategyMode.homework.Role.King;
import StrategyMode.homework.behavior.SwordBehavior;

/**
 * 知道 封装、抽象、继承、多态 这四个概念 并不能让你变成一个优秀的面向对象设计者
 * 设计大师关心的是 弹性的设计——很简单的维护即可应对变化 [思考可能需要的变化及应对变化的原则]
 * 我们通常会把系统中变化的 部分 抽取出来进行封装
 *
 * 良好的OO设计必需具备 可复用、可扩展、可维护 三个特性
 */
public class Main {
    public static void main(String[] args) {
        Character king = new King();
        king.setWeaponBehavior(new SwordBehavior());
        king.fight();
    }
}
