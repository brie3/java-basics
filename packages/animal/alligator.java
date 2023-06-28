package packages.animal;

public class alligator extends animal {
    public alligator(String name, Integer age, String vaccination, String color, String species, owner owner) {
        super(name, age, vaccination, color, species, owner, 4);
    }

    @Override
    public String fly() {
        return String.format("%s: '%s' doesn't have wings", getClass().getSimpleName(), _name);
    }
}
