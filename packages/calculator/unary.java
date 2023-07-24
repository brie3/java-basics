package packages.calculator;

public class unary implements Expr {
    private String op;
    private Expr x;

    public unary(String op, Expr ex) {
        this.op = op;
        this.x = ex;
    }

    public complex Eval() {
        var real = x.Eval().getReal();
        switch (this.op) {
            case "+":
                if (real < 0) {
                    x.Eval().setReal(-real);
                }
                return x.Eval();
            case "-":
                if (real > 0) {
                    x.Eval().setReal(-real);
                }
                return x.Eval();
            default:
                System.out.println("unexpected unary op: " + this.op);
                return new complex();
        }
    }

    public ExprType Type() {
        return ExprType.Unary;
    }

    @Override
    public String toString() {
        return this.op + this.x.toString();
    }
}
