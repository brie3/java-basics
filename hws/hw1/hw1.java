package hws.hw1;

import packages.factorial.factorial;
import packages.triangular.triangular;

public class hw1 {
    public static void main(String[] args) {
        System.out.println(new triangular(5).value());
        System.out.println(new factorial(5).value());
    }
}
