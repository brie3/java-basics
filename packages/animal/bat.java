package packages.animal;

public class bat extends animal {
    public bat(String name, Integer age, String vaccination, String color, String species, owner owner) {
        super(name, age, vaccination, color, species, owner, 2);
    }

    @Override
    public String toGo() {
        return String.format("%s: '%s' have legs but can't walk", getClass().getSimpleName(), _name);
    }

    @Override
    public String sweem() {
        return String.format("%s: '%s' can't sweem", getClass().getSimpleName(), _name);
    }
}
