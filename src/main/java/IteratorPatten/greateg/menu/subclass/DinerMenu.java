package IteratorPatten.greateg.menu.subclass;

import IteratorPatten.badeg.MenuItem;
import IteratorPatten.greateg.menu.Menu;

import java.util.Iterator;

public class DinerMenu implements Menu {
    static final int MAX_ITEMS = 6;
    private int numOfItems = 0;
    private final MenuItem[] menuItems;

    public DinerMenu() {
        menuItems = new MenuItem[MAX_ITEMS];
        addItem("Vegetarian BLT", "Fakin' Bacon & lettuce & tomato on whole wheat", true, 2.99);
        addItem("BLT", "Bacon & lettuce & tomato on whole wheat", false, 2.99);
        addItem("Soup of the day", "Potato salad", false, 3.29);
        addItem("Hotdog", "saurkraut & relish & onions & topped with cheese", false, 3.05);
    }

    private void addItem(String name, String description, boolean vegetarian, double price) {
        if (numOfItems >= MAX_ITEMS) {
            System.err.println("Menu is full, can't add.");
            return;
        }
        menuItems[numOfItems] = new MenuItem(name, description, vegetarian, price);
        numOfItems += 1;
    }

    public MenuItem[] getMenuItems() {
        return menuItems;
    }

    /**
     * 一个实例 可以 new 多个迭代器，且均应 从零开始 互不干扰
     * @return DinerMenu 迭代器
     */
    @Override
    public Iterator<MenuItem> iterator() {
        return new DinerMenuIterable();
    }

    /**
     * 照抄 ArrayList.Itr
     */
    private class DinerMenuIterable implements Iterator<MenuItem> {
        private int cursor;

        @Override
        public boolean hasNext() {
            return cursor < numOfItems;
        }

        @Override
        public MenuItem next() {
            return menuItems[cursor++];
        }
    }

}
