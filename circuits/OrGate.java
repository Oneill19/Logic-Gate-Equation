package circuits;

public class OrGate extends Gate {
    //constructor
    public OrGate(Gate[] inGates) {
        super(inGates);
    }

    //method that return the true if there is at least one true in the inValues array
    @Override
    protected boolean func(boolean[] inValues) throws CircuitException {
        for (boolean b : inValues)
            if (b)
                return true;
        return false;
    }

    //return the name of the gate
    @Override
    public String getName() {
        return "OR";
    }

    //simplify the gate
    @Override
    public Gate simplify() {
        Gate[] temp = new Gate[inGates.length]; //create a new temp gate array
        int index = 0;
        for (Gate inGate : inGates) {
            if (inGate.simplify() instanceof TrueGate)  //if there is an input of true instance return it
                return TrueGate.instance();
            else if (!(inGate.simplify() instanceof FalseGate))
                temp[index++] = inGate.simplify();
        }
        if (temp[0] == null)    //if the temp array is empty so all the inputs are true and return FalseGate
            return FalseGate.instance();
        else if (temp.length == 1 || temp[1] == null)    //if there is only one input in the array return it
            return temp[0];
        return new OrGate(temp);   //else return a new OrGate with the temp gate array
    }
}
