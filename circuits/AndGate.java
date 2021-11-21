package circuits;

public class AndGate extends Gate {
    //constructor
    public AndGate(Gate[] inGates) {
        super(inGates);
    }

    //method that return the true if there are no false instances in the inValues array
    @Override
    protected boolean func(boolean[] inValues) throws CircuitException {
        for (boolean b : inValues)
            if (!b)
                return false;
        return true;
    }

    //return the name of the gate
    @Override
    public String getName() {
        return "AND";
    }

    //simplify the gate
    @Override
    public Gate simplify() {
        Gate[] temp = new Gate[inGates.length]; //create a new temp gate array
        int index = 0;
        for (Gate inGate : inGates) {  //if there is an input of false instance return it
            if (inGate.simplify() instanceof FalseGate)
                return FalseGate.instance();
            else if (!(inGate.simplify() instanceof TrueGate))
                temp[index++] = inGate.simplify();
        }
        if (temp[0] == null)    //if the temp array is empty so all the inputs are true and return TrueGate
            return TrueGate.instance();
        else if (temp.length == 1 || temp[1] == null)    //if there is only one input in the array return it
            return temp[0];
        return new AndGate(temp);   //else return a new AndGate with the temp gate array
    }
}
