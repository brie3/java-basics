package hws.hw6;

import packages.notebook.util;
import packages.filter.filter;

public class hw6 {

    public static void main(String[] args) {
        new filter(System.out, System.console(), util.gen(10_000));
    }
}
