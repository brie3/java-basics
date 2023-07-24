package packages.calculator;

public class binary implements Expr {
    private String op;
    private Expr x, y;

    public binary(String op, Expr x, Expr y) {
        this.op = op;
        this.x = x;
        this.y = y;
    }

    public complex Eval() {
        switch (this.op) {
            case "+":
                return this.x.Eval().add(this.y.Eval());
            case "-":
                return this.x.Eval().sub(this.y.Eval());
            case "*":
                return this.x.Eval().mul(this.y.Eval());
            case "/":
                return this.x.Eval().div(this.y.Eval());
            default:
                System.out.println("unexpected binary op: " + this.op);
                return new complex();
        }
    }

    public ExprType Type() {
        return ExprType.Binary;
    }

    @Override
    public String toString() {
        return this.x.toString() + this.op + this.y.toString();
    }
}
