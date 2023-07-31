package packages.user.model;

public enum Sex {
    UNSPECIFIED("unspecified"), MALE("m"), FEMALE("f");

    private String value;

    Sex(final String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return this.getValue();
    }

    public static Sex fromString(String text) {
        for (Sex s : Sex.values()) {
            if (s.value.equalsIgnoreCase(text)) {
                return s;
            }
        }
        return UNSPECIFIED;
    }
}
