package packages.query;

import java.util.*;

public class query {
    private String query = "";

    public query(String s) {
        if (s.length() < 5) {
            return;
        }
        s = s.substring(1, s.length() - 1);
        s = s.replace("\"", "");
        List<String> items = Arrays.asList(s.split("\\s*,\\s*"));
        StringBuilder sb = new StringBuilder();
        for (String string : items) {
            var keyValue = string.split(":");
            if (keyValue.length > 2)
                return; // TODO: error

            if (keyValue[1].equals("null"))
                continue;

            sb.append(" AND ");
            sb.append(keyValue[0]);
            sb.append('=');
            sb.append(keyValue[1]);
        }
        query = "select * from students WHERE" + sb.toString().substring(4);
    }

    public String value() {
        return query;
    }
}
