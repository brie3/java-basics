package packages.paramedic;

public class nurse extends paramedic {
    public nurse(String name) {
        super(name);
    }

    public void heal() {
        // TODO: heal
    }

    public type type() {
        return type.Nurse;
    }

    public String toString() {
        return _name;
    }
}
