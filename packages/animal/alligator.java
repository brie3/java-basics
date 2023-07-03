package packages.animal;

public class alligator extends animal {
    public alligator(String name, Integer age, String vaccination, owner owner) {
        super(name, age, vaccination, color.Green, species.Reptile, owner, 4, 10, 20, 0, sound.Aligator);
    }

    @Override
    public int fly() {
        // System.out.printf("%s: '%s' doesn't have wings\n",
        // getClass().getSimpleName(), _name);
        return _flySpeed;
    }
}
