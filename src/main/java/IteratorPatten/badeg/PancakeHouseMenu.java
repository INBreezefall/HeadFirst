package IteratorPatten.badeg;

import java.util.ArrayList;

public class PancakeHouseMenu {
    private final ArrayList<MenuItem> menuItems;

    public PancakeHouseMenu() {
        menuItems = new ArrayList<>();
        addItem("K&B's Pancake Breakfast", "scrambled eggs, toast", true, 2.99);
        addItem("Regular Pancake Breakfast", "fried eggs, sausage", false, 3.49);
        addItem("Blueberry Pancakes", "fresh blueberries", true, 3.49);
        addItem("Waffles", "choice of blueberries or strawberries", true, 3.59);
    }

    private void addItem(String name, String description, boolean vegetarian, double price) {
        menuItems.add(new MenuItem(name, description, vegetarian, price));
    }

    public ArrayList<MenuItem> getMenuItems() {
        return menuItems;
    }
}
