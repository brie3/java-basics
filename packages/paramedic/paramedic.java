package packages.paramedic;

public abstract class paramedic {
    String _name;

    public paramedic(String name) {
        _name = name;
    }

    public abstract void heal();

    public abstract type type();

    public abstract String toString();
}
