package CompositePattern.example.iterator;

import CompositePattern.example.composite.Menu;
import CompositePattern.example.composite.MenuComponent;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Stack;


@SuppressWarnings({"StatementWithEmptyBody", "unused"})
public class CompositeIterator implements Iterator<MenuComponent> {
    public static class UniqUtil {
        static ThreadLocal<HashSet<String>> threadLocal = new ThreadLocal<>();
        static {
            threadLocal.set(new HashSet<>());
        }

        public static ThreadLocal<HashSet<String>> getThreadLocal() {
            return threadLocal;
        }
    }
    Stack<Iterator<MenuComponent>> stack = new Stack<>();
    String name;

    public CompositeIterator(Iterator<MenuComponent> iterator, String name) {
        stack.push(iterator);
        this.name = name;

    }

    /**
     * hasNext 进入 子组件 内部
     * @return boolean
     */
    @Override
    public boolean hasNext() {
        // 1.栈空 代表 当前节点的所有子菜单及自身都遍历结束
        if (stack.empty()) {
            // System.out.println("[hasNext] 1.1 " + "empty " + this.name);
            return false;
        } else {
            Iterator<MenuComponent> iterator = stack.peek();
            // System.out.println("[hasNext] 1.2 " + this.name + " " + stack);
            // printStack();
            // 2.子菜单 递归遍历
            // 2.1 栈顶 子菜单 Iterator 内部没有元素 则 弹栈 并 回到次栈顶 同级或上级组件 Iterator 再触发 hasNext 执行 [递归点 1]
            // 如果 子菜单 stack 栈顶仍为空 则 子菜单.hasNext() 返回 false 至 顶级菜单递归调用处 ↓↓↓ if (!iterator.hasNext())] 顶级菜单 stack 弹出 栈顶的子菜单
            if (!iterator.hasNext()) {
                Iterator<MenuComponent> popItr = stack.pop();// 清空 子菜单 Stack 栈顶，继续调用 子菜单 hasNext
                if (popItr instanceof CompositeIterator) {
                    boolean remove = UniqUtil.getThreadLocal().get().remove(((CompositeIterator) popItr).name.split("\\$")[0]);
                    // System.out.println("[hasNext] remove " + popItr.toString().split("\\$")[0] + " " + remove);
                }
                // System.out.println("[hasNext] 2 after pop " + this.name + " " + stack);
                return hasNext();
            }
            // 2.2 栈顶 子菜单 Iterator 内有元素 则 继续遍历
            else {
                return true;
            }
        }
    }

    /**
     * next 方法 只是返回可迭代集合的下一个元素 不要在 这个方法内部 与 具体类元素的具体方法 关联调用
     * 先 next 返回 子组件，再调用 hasNext 进入子组件内部进行遍历
     * @return 下一个元素
     */
    @Override
    public MenuComponent next() {
        // 1.查看栈顶 迭代器(Menu CompositeIterator)
        Iterator<MenuComponent> iterator = stack.peek();
        // printStack();
        // System.out.println("[next] 1 peek: cur=" + this.name + " target=" + iterator + " " + Thread.currentThread().getName());
        // 2.递归取出下一个 组件 [取到 ArrayList$Itr 就不会再递归 CompositeIterator.next() 只是取 ArrayList 第一个元素 Pasta]
        // [Iterator instanceof CompositeIterator 才会递归当前 next() 方法] [递归点 2]
        MenuComponent component = iterator.next();
        // System.out.println("[next] 1.1 component: " + component.getName() + " " + this.name);
        // 3.菜单组件 则 将子菜单迭代器 压入栈顶
        if (component instanceof Menu) {
            // iterator 产生一个新的 CompositeIterator => 空 Menu = 空 Stack
            Iterator<MenuComponent> pushedItr = component.iterator();
            // 怎么解决重复压栈的问题 == 单个 component.iterator() 会被复数次调用 分别压入 当前组件的所有上层菜单(顶层菜单 & 当前组件的父层菜单)
            // 核心: 如何只压一次只进一个栈
            // 实现: ThreadLocal
            // ①判断是否为 当前栈(当前Itr) 的 子组件 是的话 压入，避免 子组件的 间接上层父组件压入
            // ②判断当前 子组件 iterator() 调用次数只调用一次
            if (!UniqUtil.getThreadLocal().get().contains(component.getName())) {
                // System.out.println("[next] push: " + this.name + " <= " + pushedItr + "@" + pushedItr.hashCode());
                stack.push(pushedItr);
                UniqUtil.getThreadLocal().get().add(component.getName());
            } else {
                // System.out.println("[next] not push: " + this.name + " <= " + pushedItr + "@" + pushedItr.hashCode());
            }
        }
        // System.out.println("[next] 2 stack: " + stack + " " + this.name + " " + Thread.currentThread().getName());
        // System.out.println("[next] 3 return: " + component.getName() + " " + Thread.currentThread().getName());
        // 4.返回 组件
        return component;
    }

    @Override
    public String toString() {
        return name;
    }

    public void printStack() {
        for (StackTraceElement ste : Thread.currentThread().getStackTrace()) {
            System.out.println(ste);
        }
    }
    public void printStackWithThrowable() {
        StringWriter sw = new StringWriter();
        new Throwable("").printStackTrace(new PrintWriter(sw));
        String stackTrace = sw.toString();
        System.out.println(stackTrace);
    }
}
