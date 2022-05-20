package CommandPattern._2_greateg;

public class DadAndSonInstanceVariableTest {
    public static void main(String[] args) {
        Dad dad = new Dad();
        System.out.println(dad.name);           // dad
        Son_1 son_1 = new Son_1();
        System.out.println(son_1.name);           // son_1
        System.out.println(((Dad) son_1).name);   // dad
        // 即使子类声明了与父类完全一样的成员变量，也不会覆盖掉父类的成员变量。
        // 而是在子类实例化时，会同时定义两个成员变量，子类也可以同时访问到这两个成员变量，但父类不能访问到子类的成员变量（父类不知道子类的存在

        dad.printName();                        // dad
        son_1.printName();                        // son_1
        ((Dad) son_1).printName();                // son_1
        // 而具体在方法中使用成员变量时，究竟使用的是父类还是子类的成员变量，则由方法所在的类决定；
        // 即，方法在父类中定义和执行，则使用父类的成员变量，方法在子类中定义（包括覆盖父类方法）和执行，则使用子类的成员变量。

        Son_2 son_2 = new Son_2();
        System.out.println(son_2.name);
        System.out.println(dad.name);
    }


}

class Dad {
    public String name = "dad";

    public void printName() {
        System.out.println(name);
    }
}

/**
 * 方法①
 * 维护两个实例变量
 * Son_1 中存在一个 实例变量 name 父类 Dad 中也存在一个 实例变量 name
 * this.name && super.name
 * 并且 子类 需要复写 父类 printName 方法
 * 否则直接使用 父类 printName 调用的是其语境下的 super.name 实例变量
 */
class Son_1 extends Dad {
    public String name = "son_1";

    @Override
    public void printName() {
        System.out.println(name);
    }
}

/**
 * 方法②
 * 只 维护一个变量 —— 位于 父类 Dad 的 name 实例变量
 */
class Son_2 extends Dad {
    public Son_2() {
        super.name = "son_2";
    }
}

/*
  方法③
  将 Dad.name 声明为 public static 即可
 */