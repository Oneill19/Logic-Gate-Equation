package circuits;

public class NotGate extends Gate {
    //constructor
    public NotGate(Gate in) { super(new Gate[]{in}); }

    //return the opposite boolean value of the given value
    @Override
    protected boolean func(boolean[] inValues) throws CircuitException {
        return !inValues[0];
    }

    //return the name of the gate
    @Override
    public String getName() {
        return "NOT";
    }

    //simplify the gate
    @Override
    public Gate simplify() {
        if (inGates[0].simplify() instanceof TrueGate)  //if the input is TrueGate return FalseGate
            return FalseGate.instance();
        else if (inGates[0].simplify() instanceof FalseGate)    //if the input is FalseGate return TrueGate
            return TrueGate.instance();
        else if (inGates[0].simplify() instanceof NotGate) //if the the input is non-simplified NotGate return the grandchildren
            return inGates[0].simplify().inGates[0].simplify();
        return new NotGate(inGates[0].simplify());  //if the input is not-simplified return new NotGate with the simplify of the input
    }
}
