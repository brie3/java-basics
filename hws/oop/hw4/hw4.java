package hws.oop.hw4;

import packages.linkedList.singly.*;

public class hw4 {
    public static void main(String[] args) {
        singly<Integer> singly1 = new singly<>();
        singly1.pushFront(2);
        singly1.pushFront(1);
        singly1.pushBack(3);

        singly<Integer> singly2 = new singly<>();
        singly2.pushFront(1);
        singly2.pushFront(2);
        singly2.pushFront(3);

        singly1.join(singly2);
        singly1.update(5, 0);
        singly1.remove(3);

        singly1.toString();
        System.out.println(singly1.toString()); // class packages.linkedList.singly.singly[1, 2, 3, 2, 0]
    }
}
