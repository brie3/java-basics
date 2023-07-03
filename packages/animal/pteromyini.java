package packages.animal;

public class pteromyini extends animal {
    public pteromyini(String name, Integer age, String vaccination, owner owner) {
        super(name, age, vaccination, color.Brown, species.Mammal, owner, 4, 15, 0, 5, sound.Sqirl);
    }

    @Override
    public int swim() {
        // System.out.printf("%s: '%s' can't swim probably\n",
        // getClass().getSimpleName(), _name);
        return _swimSpeed;
    }
}
