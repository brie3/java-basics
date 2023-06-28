package hws.syntax.hw4;

import java.util.*;

public class hw4 {
    public static void main(String[] args) {
        var dequeueA = new LinkedList<>(Arrays.asList(new Integer[] { 3, 2, 1 }));
        var dequeueB = new LinkedList<>(Arrays.asList(new Integer[] { 5, 4, 3 }));
        System.out.println(reverse(sum(dequeueA, dequeueB)).toString()); // [4, 6, 8]
        System.out.println(reverse(multiply(dequeueA, dequeueB)).toString()); // [4, 2, 4, 3, 5]
    }

    static LinkedList<Integer> sum(LinkedList<Integer> a, LinkedList<Integer> b) {
        LinkedList<Integer> out = new LinkedList<>();
        var ai = a.iterator();
        var bi = b.iterator();
        var addToNext = 0;
        while (ai.hasNext() || bi.hasNext()) {
            var sum = 0;
            if (ai.hasNext()) {
                sum += ai.next();
            }
            if (bi.hasNext()) {
                sum += bi.next();
            }
            sum += addToNext;
            addToNext = sum / 10;
            out.addLast(sum - addToNext * 10);
        }
        if (addToNext != 0) {
            out.addLast(addToNext);
        }
        return out;
    }

    static LinkedList<Integer> reverse(LinkedList<Integer> a) {
        LinkedList<Integer> out = new LinkedList<>();
        var ai = a.iterator();
        while (ai.hasNext()) {
            out.addFirst(ai.next());
        }
        return out;
    }

    /*
     * _______1 2 3
     * *_____ 3 4 5
     * ------------
     * _______6 1 5
     * +___ 4 9 2
     * ___3 6 9
     * ------------
     * ___4 2 4 3 5
     */
    static LinkedList<Integer> multiply(LinkedList<Integer> a, LinkedList<Integer> b) {
        LinkedList<Integer> out = new LinkedList<>();
        var bi = b.iterator();
        var j = 0;
        while (bi.hasNext()) {
            var tmp = multiplyByDigit(a, bi.next());
            for (int i = 0; i < j; i++) {
                tmp.addFirst(0);
            }
            out = sum(out, tmp);
            j++;
        }
        return out;
    }

    static LinkedList<Integer> multiplyByDigit(LinkedList<Integer> a, int d) {
        LinkedList<Integer> out = new LinkedList<>();
        var ai = a.iterator();
        var addToNext = 0;
        while (ai.hasNext()) {
            var sum = addToNext + ai.next() * d;
            addToNext = sum / 10;
            out.addLast(sum - addToNext * 10);
        }
        if (addToNext != 0) {
            out.addLast(addToNext);
        }
        return out;
    }
}
