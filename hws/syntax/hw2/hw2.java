package hws.syntax.hw2;

import packages.bubble.bubble;
import packages.query.query;

public class hw2 {
    public static void main(String[] args) {
        System.out.println(
                new query("{\"name\":\"Ivanov\", \"country\":\"Russia\", \"city\":\"Moscow\", \"age\":\"null\"}")
                        .value());
        new bubble(new int[] { 1, 3, 4, 2 });
    }
}
