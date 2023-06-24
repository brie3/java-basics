package packages.notebook;

import java.util.Locale;

public enum os {
    Windows, Unix, MacOS, Unknown;

    public static os string(String code) {
        switch (code) {
            case "windows":
                return Windows;
            case "unix":
                return Unix;
            case "macos":
                return MacOS;
            default:
                return Unknown;
        }
    }

    public static String ToString() {
        var vv = os.values();
        var out = "";
        for (os v : vv) {
            out += ", " + v.name().toLowerCase(Locale.US);
        }
        return "[" + out.substring(2) + "]";
    }
}
