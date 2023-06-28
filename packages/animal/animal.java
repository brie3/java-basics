package packages.animal;

public class animal {
    String _name;
    Integer _age;
    String _vaccination;
    String _color;
    String _species;
    owner _owner;
    Integer _legsCount;

    public animal(String name, Integer age, String vaccination, String color,
            String species, owner owner, Integer legsCount) {
        _name = name;
        _age = age;
        _vaccination = vaccination;
        _color = color;
        _species = species;
        _owner = owner;
        _legsCount = legsCount;
    }

    public animal(String color, String species, Integer legsCount) {
        this(null, null, null, color, species, null, legsCount);
    }

    public Integer getAge() {
        return _age;
    }

    public void setAge(Integer age) {
        _age = age;
    }

    @Override
    public String toString() {
        return String.format("%s: {name = %s, owner = %s}", getClass().getSimpleName(), _name, _owner);
    }

    public String toGo() {
        return String.format("%s: '%s' is going", getClass().getSimpleName(), _name);
    }

    public String fly() {
        return String.format("%s: '%s' is flying", getClass().getSimpleName(), _name);
    }

    public String sweem() {
        return String.format("%s: '%s' is sweeming", getClass().getSimpleName(), _name);
    }
}