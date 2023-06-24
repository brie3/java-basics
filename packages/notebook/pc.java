package packages.notebook;

public class pc implements notebook {
    color _color = null;
    os _os = null;
    Integer _hdBytes = 0;
    Integer _ramBytes = 0;

    public pc(color color, os os, Integer hdBytes, Integer ramBytes) {
        _color = color;
        _os = os;
        _hdBytes = hdBytes;
        _ramBytes = ramBytes;
    }

    public color Color() {
        return _color;
    }

    public os OS() {
        return _os;
    }

    public Integer HD() {
        return _hdBytes;
    }

    public Integer Ram() {
        return _ramBytes;
    }

    @Override
    public String toString() {
        return "{" + "\"color\":\"" + _color + "\"" + "\"os\":\"" + _os + "\"" + "\"hd\":\"" + _hdBytes + "\""
                + "\"ram\":\"" + _ramBytes + "\"}";
    }
}
