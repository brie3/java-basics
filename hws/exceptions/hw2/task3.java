package hws.exceptions.hw2;

import java.io.*;

public class task3 {
    public task3() {
        try {
            int a = 90;
            int b = 3;
            System.out.println(a / b);
            printSum(23, 234);
            int[] abc = { 1, 2 };
            abc[3] = 9;
        } catch (Throwable ex) {
            System.out.println("Что-то пошло не так...");
        }
        // } catch (NullPointerException ex) { // It is already handled by the catch
        // block for Throwable
        // System.out.println("Указатель не может указывать на null!");
        // } catch (IndexOutOfBoundsException ex) { // It is already handled by the
        // catch block for Throwable
        // System.out.println("Массив выходит за пределы своего размера!");
        // }
    }

    public static void printSum(Integer a, Integer b) throws FileNotFoundException {
        System.out.println(a + b);
    }
}
