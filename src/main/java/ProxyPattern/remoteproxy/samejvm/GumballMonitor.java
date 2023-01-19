package ProxyPattern.remoteproxy.samejvm;

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
