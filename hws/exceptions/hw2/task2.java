package hws.exceptions.hw2;

public class task2 {
    public task2() {
        try {
            // int d = 0;
            // double catchedRes1 = intArray[8] / d;
            // деление на ноль; intArray не определен
            // System.out.println("catchedRes1 = " + catchedRes1);
        } catch (ArithmeticException e) {
            System.out.println("Catching exception: " + e);
        }

    }
}
