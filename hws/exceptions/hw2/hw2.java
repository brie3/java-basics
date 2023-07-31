package hws.exceptions.hw2;

public class hw2 {
    public static void main(String[] args) {
        new task1();
        new task2();
        new task3();
        try {
            new task4();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
