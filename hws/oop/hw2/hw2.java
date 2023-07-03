package hws.oop.hw2;

import packages.vetclinic.vetclinic;
import packages.paramedic.doctor;
import packages.paramedic.nurse;
import packages.vetclinic.util;

public class hw2 {
    public static void main(String[] args) {
        var vc = new vetclinic(util.gen(20));
        System.out.printf("\nrunnables are: %s\n", vc.getRunnables());
        System.out.printf("\nflyables are: %s\n\n", vc.getFlyables());
        System.out.printf("\nsoundables are: %s\n\n", vc.getSoundables());
        System.out.printf("\nswimmables are: %s\n\n", vc.getSwimmables());

        System.out.println(new doctor("Vasia"));
        System.out.println(new nurse("Marfa"));
    }
}
