package packages.calculator;

public class unary implements Expr {
    private String op;
    private Expr x;

    public unary(String op, Expr ex) {
        this.op = op;
        this.x = ex;
    }

    public double Eval() {
        switch (this.op) {
            case "+":
                return +this.x.Eval();
            case "-":
                return -this.x.Eval();
            default:
                System.out.println("unexpected unary op: " + this.op);
                return 0;
        }
    }

    public ExprType Type() {
        return ExprType.Unary;
    }

    public String String() {
        return this.op + this.x.String();
    }
}
