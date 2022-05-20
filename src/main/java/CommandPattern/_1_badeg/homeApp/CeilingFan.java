package CommandPattern._1_badeg.homeApp;

public class CeilingFan {
    public static final int HIGH = 3;
    public static final int MEDIUM = 2;
    public static final int LOW = 1;
    public static final int OFF = 0;
    String location;
    int speed;

    public CeilingFan(String location) {
        this.location = location;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        if (speed <= 3 && speed >= 0) {
            this.speed = speed;
            System.out.println("Ceiling Fan Current Speed: " + this.speed);
        }
    }
}
