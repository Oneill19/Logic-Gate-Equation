package circuits;

public class Main {

    public void test_true_gate() throws CircuitException {
        System.out.println("True Gate test");
        Gate g = TrueGate.instance();
        System.out.println(g);
        System.out.println();
    }

    public void test_false_gate() throws CircuitException {
        System.out.println("False Gate test");
        Gate g = FalseGate.instance();
        System.out.println(g);
        System.out.println();
    }

    public void test_and_gate() throws CircuitException {
        System.out.println("And Gate test");
        Gate g = new AndGate(new Gate[] { TrueGate.instance(), FalseGate.instance() });
        System.out.println(g + " = " + g.simplify());
        System.out.println();
    }

    public void test_or_gate() throws CircuitException {
        System.out.println("Or Gate test");
        Gate g = new OrGate(new Gate[] { TrueGate.instance(), FalseGate.instance() });
        System.out.println(g + " = " + g.simplify());
        System.out.println();
    }

    public void test_not_gate() throws CircuitException {
        System.out.println("Not Gate test");
        Gate g = new NotGate(FalseGate.instance());
        System.out.println(g + " = " + g.simplify());
        System.out.println();
    }

    public void test_var_gate() throws  CircuitException {
        System.out.println("Test Var Gate");
        VarGate g = new VarGate("blue");
        System.out.println(g + " = " + g.simplify());
        g.setVal(true);
        System.out.println(g + " = " + g.simplify());
        g.setVal(false);
        System.out.println(g + " = " + g.simplify());
        System.out.println();
    }

    public void test_calc() throws CircuitException {
        System.out.println("Calc test:");
        VarGate v1 = new VarGate("1");
        VarGate v2 = new VarGate("2");
        Gate g1 = new Or2Gate(FalseGate.instance(), TrueGate.instance());
        Gate g2 = new Or2Gate(v1, new NotGate(v2));
        Gate out = new AndGate(new Gate[]{g1, g2, TrueGate.instance()});
        v1.setVal(false);
        v2.setVal(true);
        System.out.println(out);
        System.out.println();
    }

    public void test_simplify() throws CircuitException {
        System.out.println("Simplify test:");
        VarGate v1 = new VarGate("1");
        VarGate v2 = new VarGate("2");
        Gate g1 = new Or2Gate(FalseGate.instance(), TrueGate.instance());
        Gate g2 = new Or2Gate(v1, new NotGate(v2));
        Gate out = new AndGate(new Gate[] { g1, g2, TrueGate.instance() });
        v1.setVal(false);
        System.out.println(out + " = " + out.simplify());
        System.out.println();
    }

    public static void main(String[] args) {
        Main m = new Main();
        try {
            m.test_true_gate();
            m.test_false_gate();
            m.test_and_gate();
            m.test_or_gate();
            m.test_not_gate();
            m.test_var_gate();
            m.test_calc();
            m.test_simplify();
        } catch (CircuitException ignored) {}
    }
}
