package IteratorPartten.greateg;

import IteratorPartten.badeg.MenuItem;
import IteratorPartten.greateg.menu.Menu;
import IteratorPartten.greateg.menu.subclass.CafeMenu;
import IteratorPartten.greateg.menu.subclass.DinerMenu;
import IteratorPartten.greateg.menu.subclass.PancakeHouseMenu;

import java.util.ArrayList;
import java.util.Objects;

/**
 * 解决了什么问题？
 * 1.无需关心 菜单的内部实现 只针对 Iterable 接口编程
 * 2.不同实现的遍历细节 被屏蔽在了 自己的实现类中，而不会 耦合进入 Waitress 中 [换句话说 复杂度 分散到 各个实现类中]
 * 3.没有重复代码
 *
 */
@SuppressWarnings("rawtypes")
public class Waitress {
    // 这里应该可以令你 想起 天气布告版 用一个 Array 来装载 多个 observer
    private final ArrayList<Menu> allMenus;

    // 这里 没有写死类型/以内部成员变量装载菜单，采用了更加灵活的 Iterable 初始化
    public Waitress(ArrayList<Menu> allMenus) {
        this.allMenus = allMenus;
    }

    public void printAllMenuOrAllVegMenu(boolean isOnlyVeg) {
        for (Iterable<MenuItem> menuItems : allMenus) {
            for (MenuItem menuItem : menuItems) {
                printItem(menuItem, isOnlyVeg);
            }
        }
    }

    public void printBreakfastMenu(boolean isOnlyVeg) {
        for (MenuItem item : Objects.requireNonNull(filter(PancakeHouseMenu.class))) {
            printItem(item, isOnlyVeg);
        }
    }

    public void printLunchMenu(boolean isOnlyVeg) {
        for (MenuItem item : Objects.requireNonNull(filter(DinerMenu.class))) {
            printItem(item, isOnlyVeg);
        }
    }

    public void printCafe(boolean isOnlyVeg) {
        for (MenuItem item : Objects.requireNonNull(filter(CafeMenu.class))) {
            printItem(item, isOnlyVeg);
        }
    }

    private Iterable<MenuItem> filter(Class c) {
        for (Iterable<MenuItem> menu : allMenus) {
            if (menu.getClass().equals(c)) {
                return menu;
            }
        }
        return null;
    }

    private void printItem(MenuItem menu, boolean isOnlyVeg) {
        if (isOnlyVeg) {
            if (menu.isVegetarian())
                System.out.println(menu.getName() + ": " + menu.getDescription() + ". price: " + menu.getPrice());
        } else {
            System.out.println(menu.getName() + ": " + menu.getDescription() + ". price: " + menu.getPrice());
        }
    }
}
