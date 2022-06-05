package CompositePattern.example;

import CompositePattern.example.composite.MenuComponent;

/**
 * 快乐的女招待员
 */
public class Waitress {
    MenuComponent allMenus;

    public Waitress(MenuComponent allMenus) {
        this.allMenus = allMenus;
    }

    public void printMenu() {
        allMenus.print();
    }

    /**
     * 先返回 组件，再遍历 组件内部
     */
    public void printVegMenuWithIterator() {
        for (MenuComponent component : allMenus) {
            // 这里可以 修改 Menu 组件的 isVegetarian 返回 false 从而达到 无需 Catch
            // 但是 这不符合 isVegetarian false 语义，故此 简单来说 上面可行，但真正开发时 理应重新设计 isVegetarian 函数
            try {
                if (component.isVegetarian()) {
                    component.print();
                }
            } catch (UnsupportedOperationException ignored) {

            }
            // System.out.println("[Waitress] " + component.getName() + "\n");
        }
    }
}
