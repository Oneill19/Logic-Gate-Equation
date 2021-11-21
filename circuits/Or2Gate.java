package circuits;

public class Or2Gate extends OrGate {
    //constructor that send an array of two members to create an OrGate with two inputs
    public Or2Gate(Gate g1, Gate g2) {
        super(new Gate[]{g1, g2});
    }
}
