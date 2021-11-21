package circuits;

public class FalseGate extends Gate {
    private static FalseGate instance = null;

    //constructor
    private FalseGate() { super(null); }

    //if instance in null throw an exception else return false
    @Override
    protected boolean func(boolean[] inValues) throws CircuitException {
        return false;
    }

    //return the name of the gate
    @Override
    public String getName() {
        return "F";
    }

    //return the instance
    @Override
    public Gate simplify() {
        return instance;
    }

    //create a singleton object
    public static Gate instance() {
        if (instance == null)
            instance = new FalseGate();
        return instance;
    }
}
