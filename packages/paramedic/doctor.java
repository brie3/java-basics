package packages.paramedic;

public class doctor extends paramedic {
    public doctor(String name) {
        super(name);
    }

    public void heal() {
        // TODO: heal
    }

    public type type() {
        return type.Doctor;
    }

    public String toString() {
        return _name;
    }
}
