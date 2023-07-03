package packages.animal;

public class bat extends animal {
    public bat(String name, Integer age, String vaccination, owner owner) {
        super(name, age, vaccination, color.Gray, species.Mammal, owner, 2, 0, 0, 15, sound.Bat);
    }

    @Override
    public int run() {
        // System.out.printf("%s: '%s' have legs but can't run\n",
        // getClass().getSimpleName(), _name, _runSpeed);
        return _runSpeed;
    }

    @Override
    public int swim() {
        // System.out.printf("%s: '%s' can't swim\n", getClass().getSimpleName(),
        // _name);
        return _swimSpeed;
    }
}
