package IteratorPartten.greateg.menu.subclass;

import IteratorPartten.badeg.MenuItem;
import IteratorPartten.greateg.menu.Menu;

import java.util.Hashtable;
import java.util.Iterator;

public class CafeMenu implements Menu {
    private final Hashtable<String, MenuItem> menuItems = new Hashtable<>();

    public CafeMenu() {
        addItem("Veggie Burger and Air Fires", "whole wheat bun & lettuce & tomato & fries", true, 3.99);
        addItem("Soup of the day", "side salad", false, 3.69);
        addItem("Burrito", "whole pinto beans, salsa, guacamole", true, 4.29);
    }

    private void addItem(String name, String description, boolean vegetarian, double price) {
        menuItems.put(name, new MenuItem(name, description, vegetarian, price));
    }

    public Hashtable<String, MenuItem> getMenuItems() {
        return menuItems;
    }

    @Override
    public Iterator<MenuItem> iterator() {
        return menuItems.values().iterator();
    }
}
