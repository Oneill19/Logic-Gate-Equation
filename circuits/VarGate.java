package circuits;

public class VarGate extends Gate {
    private String name;
    private Gate in;

    //constructor
    public VarGate(String name) {
        super(null);
        this.name = name;
    }

    //set the value of the VarGate
    public void setVal(boolean value) {
        if (value)
            in = TrueGate.instance();
        else
            in = FalseGate.instance();
    }

    //return the boolean value of in, throw an exception if it's not initialized
    @Override
    protected boolean func(boolean[] inValues) throws CircuitException {
        if (in == null)
            throw new CircuitException();
        return in.func(inValues);
    }

    //return the name of the gate
    @Override
    public String getName() {
        return "V" + name;
    }

    //if the gate not initialized return itself, else return the simplify of it
    @Override
    public Gate simplify() {
        if (in == null)
            return this;
        return in.simplify();
    }
}
