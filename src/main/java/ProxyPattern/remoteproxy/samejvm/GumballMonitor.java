package ProxyPattern.remoteproxy.samejvm;

/**
 * 仅供参看，这里没有提供 Main 演示方法
 * 仅仅是 方便理解 在同一个 JVM 中如何 通过 组合来掌握 某一特定对象的 实时状态
 */
@SuppressWarnings("unused")
public class GumballMonitor {
    GumballMachine machine;

    public GumballMonitor(GumballMachine machine) {
        this.machine = machine;
    }

    public void report() {
        System.out.println("Gumball Machine: " + machine.getLocation());
        System.out.println("Gumball Residue: " + machine.getResidueCount() + " gumballs");
        System.out.println("Gumball Statue: " + machine.getState());
    }
}
