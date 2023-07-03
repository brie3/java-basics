package packages.animal;

public class duck extends animal {
    public duck(String name, Integer age, String vaccination, owner owner) {
        super(name, age, vaccination, color.Gray, species.Bird, owner, 2, 5, 5, 10, sound.Duck);
    }
}
