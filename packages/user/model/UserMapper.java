package packages.user.model;

import java.util.Locale;
import java.time.format.*;
import java.time.LocalDate;

public class UserMapper {
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy").withLocale(Locale.US);

    public String map(User user) {
        return String.format("%s,%s,%s,%s,%s,%s", user.getId(), user.getFirstName(), user.getLastName(),
                user.getPhone(), user.getDOB().format(formatter), user.getSex().toString());
    }

    public User map(String line) {
        String[] lines = line.split(",");
        return new User(lines[0], lines[1], lines[2], lines[3], LocalDate.parse(lines[4], formatter),
                Sex.fromString(lines[5]));
    }
}
