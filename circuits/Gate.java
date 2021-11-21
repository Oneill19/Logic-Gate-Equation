package circuits;

public abstract class Gate {
    protected Gate[] inGates;

    //constructor
    public Gate(Gate[] inGates) {
        this.inGates = inGates;
    }

    //calculate the value of the gate
    public boolean calc() throws CircuitException {
        if (inGates == null)    //if the gate is empty return it's true, false, or var gate
            return func(null);
        boolean[] inValues = new boolean[inGates.length];   //create a boolean array in the length of the number of inputs to the gates
        for (int i = 0; i < inGates.length; i++) {  //loop than run on all the inputs to the gate
            if (inGates[i] == null) //if the i input is null throw an exception
                throw new CircuitException();
            else    //if the i input is a gate calculate the value of it
                inValues[i] = inGates[i].calc();
        }
        return func(inValues);  //call func to calculate the value by a specified gate
    }

    //abstract function that return true or false by the type of the gate
    protected abstract boolean func(boolean[] inValues) throws CircuitException;

    //abstract function that return the name of gate
    public abstract String getName();

    //abstract function that simplify the given gate
    public abstract Gate simplify();

    //represent the gate as a string
    public String toString() {
        StringBuilder returnValue = new StringBuilder(getName());   //create a new StringBuilder
        if (inGates == null)  //if there is no inputs to the gate return only the name
            return returnValue.toString();
        returnValue.append("[");
        for (Gate inGate : inGates) {   //else return all the input gates in brackets
            if (inGate != null)
                returnValue.append(inGate).append(", ");
        }
        return returnValue.delete(returnValue.length() - 2, returnValue.length()).append("]").toString();   //return the string
    }
}
