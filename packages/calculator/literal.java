package packages.calculator;

public class literal implements Expr {
    private complex l;

    public literal(double in) {
        l = new complex(in, 0);
    }

    public literal(complex c) {
        l = c;
    }

    public complex Eval() {
        return l;
    }

    public ExprType Type() {
        return ExprType.Literal;
    }
}
