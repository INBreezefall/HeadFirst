package CompositePattern.example;

import CompositePattern.example.composite.Menu;
import CompositePattern.example.composite.MenuComponent;
import CompositePattern.example.composite.MenuItem;
import CompositePattern.example.iterator.CompositeIterator;

import java.util.ArrayList;
import java.util.Iterator;

/**
 *                                   ALL MENUS
 *                   /                   |                  \
 *    PANCAKE HOUSE MENU           DINER MENU            CAFE MENU
 *    /    \          \               /    \               /    \
 *  MenuItem MenuItem MenuItem  MenuItem  DESSERT MENU  MenuItem MenuItem
 *                                          /      \
 *                                       MenuItem MenuItem
 */
public class Main {
    public static void main(String[] args) {
        // 1.所有菜单(顶级菜单 & 子菜单)
        MenuComponent pancakeHouseMenu = new Menu("PANCAKE HOUSE MENU", "Breakfast");
        MenuComponent cafeMenu = new Menu("CAFE MENU", "Dinner");

        MenuComponent dinerMenu = new Menu("DINER MENU", "Lunch");
        MenuComponent dessertMenu = new Menu("DESSERT MENU", "Dessert of course!");

        MenuComponent allMenus = new Menu("ALL MENUS", "All menus composite");

        // 2.复合 ALL MENUS
        allMenus.add(pancakeHouseMenu);
        allMenus.add(cafeMenu);

        allMenus.add(dinerMenu);

        // 3.复合 DINER MENU
        dinerMenu.add(new MenuItem("Pasta", "Spaghetti with Marinara Sauce, and a slice of sourdough bread", true, 3.89));
        dinerMenu.add(new MenuItem("Hamburger", "Hamburger with relish and onions", false, 2.99));
        dinerMenu.add(dessertMenu);

        // 4.复合 DESSERT MENU
        dessertMenu.add(new MenuItem("Apple Pie", "Apple pie with a flakey crust, topped with vanilla ice cream", true, 1.59));

        // 5.创建 Client 进行 print 调用
        Waitress waitress = new Waitress(allMenus);
        System.out.println("\n------ Print All ------");
        // waitress.printMenu();
        System.out.println("\n------ Print Veg ------");
        waitress.printVegMenuWithIterator();

        System.out.println("\n------ Print ThreadLocal ------");
        System.out.println(CompositeIterator.UniqUtil.getThreadLocal().get().toString());
    }
}
