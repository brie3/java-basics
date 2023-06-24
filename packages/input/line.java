package packages.input;

public class line {
    type _type = null;
    String _message = null;

    public line(type type, String message) {
        _type = type;
        _message = message;
    }

    public type type() {
        return _type;
    }

    public String String() {
        return _message;
    }
}
