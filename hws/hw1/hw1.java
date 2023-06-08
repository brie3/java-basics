package hws.hw1;

import packages.factorial.factorial;
import packages.prime.prime;
import packages.triangular.triangular;
import java.util.Arrays;

public class hw1 {
    public static void main(String[] args) {
        System.out.println(new triangular(5).value());
        System.out.println(new factorial(5).value());
        System.out.println(Arrays.toString(new prime(1000).value()));
    }
}
