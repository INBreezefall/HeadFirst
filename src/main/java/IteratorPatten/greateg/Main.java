package IteratorPatten.greateg;

import IteratorPatten.greateg.menu.Menu;
import IteratorPatten.greateg.menu.subclass.CafeMenu;
import IteratorPatten.greateg.menu.subclass.DinerMenu;
import IteratorPatten.greateg.menu.subclass.PancakeHouseMenu;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Menu> menus = new ArrayList<>();
        menus.add(new DinerMenu());
        menus.add(new PancakeHouseMenu());
        menus.add(new CafeMenu());
        Waitress waitressIterable = new Waitress(menus);

        System.out.println("\nPrint all");
        waitressIterable.printAllMenuOrAllVegMenu(false);
        System.out.println("\nPrint all veg");
        waitressIterable.printAllMenuOrAllVegMenu(true);
        System.out.println("\nPrint Breakfast");
        waitressIterable.printBreakfastMenu(false);
        System.out.println("\nPrint Lunch");
        waitressIterable.printLunchMenu(false);
        System.out.println("\nPrint Dinner");
        waitressIterable.printCafe(false);
    }
}
