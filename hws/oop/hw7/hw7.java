
import packages.calculator.calculator;

public class hw7 {
    public static void main(String[] args) {
        System.out.println(new calculator("3+5i + 2+5i").Parse().Eval()); // 5+10i
        System.out.println(new calculator("3+5i - 2+5i").Parse().Eval()); // 1+0i
        System.out.println(new calculator("3+5i * 2+5i").Parse().Eval()); // -19+25i
        System.out.println(new calculator("3+5i / 2+5i").Parse().Eval()); // 1.07-0.17i
    }
}
