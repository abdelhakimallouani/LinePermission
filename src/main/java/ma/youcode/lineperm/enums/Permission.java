package ma.youcode.lineperm.enums;

public enum Permission {
    Normale("---"),
    R("r"),
    W("w"),
    WR("wr");

    private final String value;

    Permission(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static Permission fromValue(String value) {

        for (Permission permission : Permission.values()) {

            if (permission.getValue().equals(value)) {
                return permission;
            }
        }

        return null;
    }
}
