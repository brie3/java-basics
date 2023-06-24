package packages.phonebook;

import java.util.*;

import packages.input.type;
import packages.input.line;

public class phonebook {
    Map<String, ArrayList<Long>> _phonebook = null;

    public phonebook() {
        _phonebook = new HashMap<String, ArrayList<Long>>();
    }

    public line addPhone(String name, Long phone) {
        var list = _phonebook.get(name);
        if (list == null) {
            _phonebook.put(name, new ArrayList<>(1));
        }
        _phonebook.get(name).add(phone);
        return new line(type.Str, "phone: " + Long.toString(phone) + " added to: " + name);
    }

    public String fetchAll() {
        var list = new ArrayList<>(_phonebook.entrySet());
        list.sort(new Comparator<Map.Entry<String, ArrayList<Long>>>() {
            @Override
            public int compare(Map.Entry<String, ArrayList<Long>> a, Map.Entry<String, ArrayList<Long>> b) {
                var al = a.getValue();
                var bl = b.getValue();
                if (al.size() < bl.size()) {
                    return 1;
                }
                return -1;
            };
        });
        return list.toString();
    }
}
