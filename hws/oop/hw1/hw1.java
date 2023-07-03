package hws.oop.hw1;

import packages.animal.*;

public class hw1 {
    public static void main(String[] args) {
        animal aligator = new alligator("ali", null, null, null);
        animal dolphin = new dolphin("dolphy", null, null, null);
        animal bat = new bat("batty", null, null, null);
        animal pteromyini = new pteromyini("pteri", null, null, null);

        aligator.run();
        aligator.fly();
        aligator.swim();
        aligator.sound();

        dolphin.run();
        dolphin.fly();
        dolphin.swim();
        dolphin.sound();

        bat.run();
        bat.fly();
        bat.swim();
        bat.sound();

        pteromyini.run();
        pteromyini.fly();
        pteromyini.swim();
        pteromyini.sound();
    }
}
