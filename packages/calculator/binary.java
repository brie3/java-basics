package packages.calculator;

public class binary implements Expr {
    private String op;
    private Expr x, y;

    public binary(String op, Expr x, Expr y) {
        this.op = op;
        this.x = x;
        this.y = y;
    }

    public double Eval() {
        switch (this.op) {
            case "+":
                return this.x.Eval() + this.y.Eval();
            case "-":
                return this.x.Eval() - this.y.Eval();
            case "*":
                return this.x.Eval() * this.y.Eval();
            case "/":
                return this.x.Eval() / this.y.Eval();
            default:
                System.out.println("unexpected binary op: " + this.op);
                return 0;
        }
    }

    public ExprType Type() {
        return ExprType.Binary;
    }

    public String String() {
        return this.x.String() + this.op + this.y.String();
    }
}
