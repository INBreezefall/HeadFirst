package IteratorPatten.badeg;

public class DinerMenu {
    static final int MAX_ITEMS = 6;
    protected int numOfItems = 0;
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
}
