package StatePattern.greateg;

public interface GumballMachineState {
    void insertQuarter();
    default void ejectQuarter() {
        System.out.println("You haven't inserted a quarter");
    }

    void turnCrank();

    void dispense();
}
