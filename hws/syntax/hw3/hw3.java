package hws.syntax.hw3;

import packages.list.list;

public class hw3 {
    public static void main(String[] args) {
        var l = new list(new Integer[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11 });
        System.out.println(l.min());
        System.out.println(l.max());
        System.out.println(l.average());
        System.out.println(l.removeEven().toString());
    }
}
