package IteratorPatten.badeg;

import java.util.ArrayList;

/**
 * 这里出现的问题:
 * 1.我们应该针对 接口编程(Iterable) 而非 实现编程(ArrayList<MenuItem> or MenuItem[])
 * 2.一旦 新增一个新的商店菜单 既不是 ArrayList 也不是 [] 比如 HashTable 就要写新的函数进行遍历
 * 3.女服务员 了解了 Menu 内部的具体实现类，但她明显不需要了解 -- 违反了封装
 * 4.两段重复代码 for 循环遍历
 *
 */
@SuppressWarnings("unused")
public class Waitress {
    public void printAllMenu() {
        printBreakfastMenu(false);
        printLunchMenu(false);
    }

    public void printAllVegetarianMenu() {
        printBreakfastMenu(true);
        printLunchMenu(true);
    }


    public void printBreakfastMenu(boolean isOnlyVeg) {
        ArrayList<MenuItem> menuItems = new PancakeHouseMenu().getMenuItems();
        for (MenuItem menu : menuItems) {
            printItem(menu, isOnlyVeg);
        }
    }

    public void printLunchMenu(boolean isOnlyVeg) {
        MenuItem[] menuItems = new DinerMenu().getMenuItems();
        for (MenuItem menu : menuItems) {
            printItem(menu, isOnlyVeg);
        }
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
