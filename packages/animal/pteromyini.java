package packages.animal;

public class pteromyini extends animal {
    public pteromyini(String name, Integer age, String vaccination, String color, String species, owner owner) {
        super(name, age, vaccination, color, species, owner, 4);
    }

    @Override
    public String sweem() {
        return String.format("%s: '%s' can't sweem probably", getClass().getSimpleName(), _name);
    }
}
