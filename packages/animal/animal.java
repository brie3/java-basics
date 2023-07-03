package packages.animal;

public class animal implements soundable, runnable, flyable, swimmable {
    String _name;
    Integer _age;
    String _vaccination;
    color _color;
    species _species;
    owner _owner;
    Integer _legsCount;
    Integer _runSpeed = 0;
    Integer _swimSpeed = 0;
    Integer _flySpeed = 0;
    sound _sound = sound.Unknown;

    public animal(String name, Integer age, String vaccination, color color,
            species species, owner owner, Integer legsCount, Integer runSpeed, Integer swimSpeed, Integer flySpeed,
            sound sound) {
        _name = name;
        _age = age;
        _vaccination = vaccination;
        _color = color;
        _species = species;
        _owner = owner;
        _legsCount = legsCount;
        _runSpeed = runSpeed;
        _swimSpeed = swimSpeed;
        _flySpeed = flySpeed;
        _sound = sound;
    }

    public animal(color color, species species, Integer legsCount) {
        this(null, null, null, color, species, null, legsCount, 0, 0, 0, sound.Unknown);
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

    public int run() {
        // System.out.printf("%s: '%s' is running with speed: %d\n",
        // getClass().getSimpleName(), _name, _runSpeed);
        return _runSpeed;
    }

    public int fly() {
        // System.out.printf("%s: '%s' is flying with speed: %d\n",
        // getClass().getSimpleName(), _name, _flySpeed);
        return _flySpeed;
    }

    public int swim() {
        // System.out.printf("%s: '%s' is swimming with speed: %d\n",
        // getClass().getSimpleName(), _name, _swimSpeed);
        return _swimSpeed;
    }

    public sound sound() {
        // System.out.printf("%s: '%s' is sounding like: %s\n",
        // getClass().getSimpleName(), _name, _sound);
        return _sound;
    }
}