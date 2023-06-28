package hws.oop.hw1;

import packages.animal.*;

public class hw1 {
    public static void main(String[] args) {
        animal aligator = new alligator("ali", null, null, "green", "Reptile", null);
        animal dolphin = new dolphin("dolphy", null, null, "blue", "Mammal", null);
        animal bat = new bat("batty", null, null, "dark", "Mammal", null);
        animal pteromyini = new pteromyini("pteri", null, null, "brown", "Mammal", null);

        System.out.println(aligator.toGo());
        System.out.println(aligator.fly());
        System.out.println(aligator.sweem());

        System.out.println(dolphin.toGo());
        System.out.println(dolphin.fly());
        System.out.println(dolphin.sweem());

        System.out.println(bat.toGo());
        System.out.println(bat.fly());
        System.out.println(bat.sweem());

        System.out.println(pteromyini.toGo());
        System.out.println(pteromyini.fly());
        System.out.println(pteromyini.sweem());
    }
}
