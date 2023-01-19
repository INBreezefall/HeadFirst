package ProxyPattern.remoteproxy.samejvm;

@SuppressWarnings("FieldMayBeFinal")
public class GumballMachine {
    private final String location;
    private int residueCount;
    private String state;

    public GumballMachine(String location, int residueCount, String state) {
        this.location = location;
        this.residueCount = residueCount;
        this.state = state;
    }

    public String getLocation() {
        return location;
    }

    public int getResidueCount() {
        return residueCount;
    }

    public String getState() {
        return state;
    }
}
