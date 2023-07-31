package packages.user.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.time.format.*;
import java.time.LocalDate;

public class RepositoryFile implements Repository {
    private UserMapper mapper;
    private FileOperation fileOperation;

    public RepositoryFile(FileOperation fileOperation) {
        this(fileOperation, new UserMapper());
    }

    public RepositoryFile(FileOperation fileOperation, UserMapper userMapper) {
        this.fileOperation = fileOperation;
        this.mapper = userMapper;
    }

    public void deleteUser(User user) {
        List<String> lines = fileOperation.readAllLines();
        List<User> users = new ArrayList<>();
        for (String line : lines) {
            users.add(mapper.map(line));
        }

        int findIndex = -1;

        for (int i = 0; i < users.size(); i++) {
            User currentUser = users.get(i);
            if (user.getId().equals(currentUser.getId())) {
                findIndex = i;
                break;
            }
        }

        if (findIndex > -1) {
            lines.remove(findIndex);
        }

        fileOperation.saveAllLines(lines);

    }

    @Override
    public List<User> getAllUsers() {
        List<String> lines = fileOperation.readAllLines();
        List<User> users = new ArrayList<>();
        for (String line : lines) {
            users.add(mapper.map(line));
        }
        return users;
    }

    @Override
    public void UpdateUser(User user, Fields field, String param) {
        switch (field) {
            case SURNAME:
                user.setLastName(param);
                break;
            case NAME:
                user.setLastName(param);
                break;
            case TELEPHONE:
                user.setPhone(param);
                break;
            case DOB:
                user.setDOB(LocalDate.parse(param, DateTimeFormatter.ofPattern("dd.MM.yyyy").withLocale(Locale.US)));
                break;
            case SEX:
                user.setSex(Sex.fromString(param));
                break;
        }
        saveUser(user);
    }

    private void saveUser(User user) {
        List<String> lines = new ArrayList<>();
        List<User> users = getAllUsers();
        for (User item : users) {
            if (user.getId().equals(item.getId())) {
                lines.add(mapper.map(user));
            } else {
                lines.add(mapper.map(item));
            }
        }
        fileOperation.saveAllLines(lines);
    }

    @Override
    public String CreateUser(User user) {

        List<User> users = getAllUsers();
        int max = 0;
        for (User item : users) {
            int id = Integer.parseInt(item.getId());
            if (max < id) {
                max = id;
            }
        }
        int newId = max + 1;
        String id = String.format("%d", newId);
        user.setId(id);
        users.add(user);
        List<String> lines = new ArrayList<>();
        for (User item : users) {
            lines.add(mapper.map(item));
        }
        fileOperation.saveAllLines(lines);
        return id;
    }
}
