package circuits;

public class And2Gate extends AndGate {
    //constructor that send an array of two members to create an AndGate with two inputs
    public And2Gate(Gate g1, Gate g2) {
        super(new Gate[]{g1, g2});
    }
}
