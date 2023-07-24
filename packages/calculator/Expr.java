package packages.calculator;

public interface Expr {
    complex Eval();

    ExprType Type();
}
