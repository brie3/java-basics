package packages.animal;

public class dolphin extends animal {
    public dolphin(String name, Integer age, String vaccination, String color, String species, owner owner) {
        super(name, age, vaccination, color, species, owner, 0);
    }

    @Override
    public String toGo() {
        return String.format("%s: '%s' doesn't have legs", getClass().getSimpleName(), _name);
    }

    @Override
    public String fly() {
        return String.format("%s: '%s' doesn't have wings", getClass().getSimpleName(), _name);
    }
}
