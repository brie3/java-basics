package packages.calculator;

public class literal implements Expr {
    private double l;

    public literal(double in) {
        this.l = in;
    }

    public double Eval() {
        return this.l;
    }

    public ExprType Type() {
        return ExprType.Literal;
    }

    public String String() {
        return Double.toString(this.l);
    }
}
