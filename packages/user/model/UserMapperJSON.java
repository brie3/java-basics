package packages.user.model;

import com.google.gson.Gson;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.time.format.*;
import java.time.LocalDate;

public class UserMapperJSON extends UserMapper {
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy").withLocale(Locale.US);

    public String map(User user) {

        Gson gson = new Gson();

        HashMap<String, String> map = new HashMap();
        map.put("id", user.getId());
        map.put("firstName", user.getFirstName());
        map.put("lastName", user.getLastName());
        map.put("phone", user.getPhone());
        map.put("dob", user.getDOB().format(formatter));
        map.put("sex", user.getSex().toString());

        return gson.toJson(map);

    }

    public User map(String line) {
        Gson gson = new Gson();
        Map<String, String> map = gson.fromJson(line, HashMap.class);
        return new User(map.get("id"), map.get("firstName"), map.get("lastName"), map.get("phone"),
                LocalDate.parse(map.get("dob"), formatter),
                Sex.fromString(map.get("sex")));
    }
}
