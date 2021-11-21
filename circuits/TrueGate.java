package circuits;

public class TrueGate extends Gate {
    private static TrueGate instance = null;

    //constructor
    private TrueGate() { super(null); }

    //if instance in null throw an exception else return true
    @Override
    protected boolean func(boolean[] inValues) throws CircuitException {
        return true;
    }

    //return the name of the gate
    @Override
    public String getName() {
        return "T";
    }

    //return the instance
    @Override
    public Gate simplify() {
        return instance;
    }

    //create a singleton object
    public static Gate instance() {
        if (instance == null)
            instance = new TrueGate();
        return instance;
    }
}
