package packages.notebook;

import java.util.*;

public enum color {
    Red, Blue, White, Unknown;

    public static color string(String code) {
        switch (code) {
            case "red":
                return Red;
            case "blue":
                return Blue;
            case "white":
                return White;
            default:
                return Unknown;
        }
    }

    public static String ToString() {
        var vv = color.values();
        var out = "";
        for (color v : vv) {
            out += ", " + v.name().toLowerCase(Locale.US);
        }
        return "[" + out.substring(2) + "]";
    }
}
