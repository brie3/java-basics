package packages.vetclinic;

import java.util.ArrayList;
import java.util.List;
import packages.animal.animal;
import packages.animal.flyable;
import packages.animal.runnable;
import packages.animal.sound;
import packages.animal.soundable;
import packages.animal.swimmable;

public class vetclinic {
    List<animal> _animals = null;

    public vetclinic(List<animal> animals) {
        _animals = animals;
    }

    public List<runnable> getRunnables() {
        var out = new ArrayList<runnable>();
        for (animal animal : _animals) {
            if (animal.run() != 0) {
                out.add(animal);
            }
        }
        return out;
    }

    public List<flyable> getFlyables() {
        var out = new ArrayList<flyable>();
        for (animal animal : _animals) {
            if (animal.fly() != 0) {
                out.add(animal);
            }
        }
        return out;
    }

    public List<swimmable> getSwimmables() {
        var out = new ArrayList<swimmable>();
        for (animal animal : _animals) {
            if (animal.swim() != 0) {
                out.add(animal);
            }
        }
        return out;
    }

    public List<soundable> getSoundables() {
        var out = new ArrayList<soundable>();
        for (animal animal : _animals) {
            if (animal.sound() != sound.Unknown) {
                out.add(animal);
            }
        }
        return out;
    }
}
