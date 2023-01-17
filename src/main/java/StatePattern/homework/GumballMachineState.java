package StatePattern.homework;

public interface GumballMachineState {
    void insertQuarter();
    default void ejectQuarter() {
        System.out.println("You haven't inserted a quarter");
    }

    void turnCrank();

    void dispense();

    default void refill(int count) {
        System.out.println("Can't refill in this time");
    }
}
