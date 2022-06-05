package CompositePattern.example.composite;

import CompositePattern.example.iterator.CompositeIterator;

import java.util.ArrayList;
import java.util.Iterator;

public class Menu extends MenuComponent {
    ArrayList<MenuComponent> menuComponents = new ArrayList<>();
    String name;
    String description;

    public Menu(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public void add(MenuComponent menuComponent) {
        menuComponents.add(menuComponent);
    }

    public void remove(MenuComponent menuComponent) {
        menuComponents.remove(menuComponent);
    }

    public boolean isChild(MenuComponent menuComponent) {
        return menuComponents.contains(menuComponent);
    }

    public MenuComponent getChild(int i) {
        return menuComponents.get(i);
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public void print() {
        System.out.print("\n" + getName());
        System.out.println(", " + getDescription());
        System.out.println("---------------------");

        for (MenuComponent menuComponent : menuComponents) {
            menuComponent.print();
        }
    }

    @Override
    public Iterator<MenuComponent> iterator() {
        Iterator<MenuComponent> iterator = menuComponents.iterator();
        // Object.toString() { getClass().getName() + "@" + Integer.toHexString(hashCode()); }
        // System.out.println("[iterator] " + name + "@" + this.hashCode() + " " + iterator);
        return new CompositeIterator(iterator, name + "$Itr@" + this.hashCode());
    }
}
