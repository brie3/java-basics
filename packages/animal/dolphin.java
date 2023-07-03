package packages.animal;

public class dolphin extends animal {
    public dolphin(String name, Integer age, String vaccination, owner owner) {
        super(name, age, vaccination, color.Blue, species.Mammal, owner, 0, 0, 30, 0, sound.Dolphin);
    }

    @Override
    public int run() {
        // System.out.printf("%s: '%s' doesn't have legs\n", getClass().getSimpleName(),
        // _name);
        return _runSpeed;
    }

    @Override
    public int fly() {
        // System.out.printf("%s: '%s' doesn't have wings\n",
        // getClass().getSimpleName(), _name);
        return _flySpeed;
    }
}
