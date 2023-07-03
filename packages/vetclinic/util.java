package packages.vetclinic;

import java.util.*;
import packages.animal.*;

public class util {
    public static ArrayList<animal> gen(int num) {
        var rand = new Random(System.currentTimeMillis());
        var out = new ArrayList<animal>(num);
        for (Integer i = 0; i < num; i++) {
            var animalPick = type.values()[rand.nextInt(type.values().length)];
            var agePick = rand.nextInt(100);
            switch (animalPick) {
                case Aligator:
                    out.add(new alligator("ali-" + i.toString(), agePick, null, null));
                    break;
                case Bat:
                    out.add(new bat("batty-" + i.toString(), agePick, null, null));
                    break;
                case Dolphin:
                    out.add(new dolphin("dolphy-" + i.toString(), agePick, null, null));
                    break;
                case Pteromyini:
                    out.add(new pteromyini("ptery-" + i.toString(), agePick, null, null));
                    break;
                case Duck:
                    out.add(new duck("ducky-" + i.toString(), agePick, null, null));
                    break;
            }
        }
        return out;
    }
}
