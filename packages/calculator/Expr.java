package packages.calculator;

public interface Expr {
    double Eval();

    ExprType Type();

    String String();
}
