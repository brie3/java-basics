package packages.user.views;

import java.time.LocalDate;
import java.util.Scanner;
import java.time.format.*;

import packages.user.controllers.UserController;
import packages.user.model.Fields;
import packages.user.model.User;
import packages.user.model.Sex;
import packages.user.utils.PhoneException;
import packages.user.utils.SexException;
import packages.user.utils.Validate;

public class ViewUser {

    private final UserController userController;
    private final Validate validate;

    public ViewUser(UserController userController, Validate validate) {
        this.userController = userController;
        this.validate = validate;
    }

    public void run() {
        Commands com = Commands.NONE;
        showHelp();
        while (true) {
            try {
                String command = prompt("Введите команду: ");
                com = Commands.valueOf(command.toUpperCase());
                if (com == Commands.EXIT)
                    return;
                switch (com) {
                    case CREATE:
                        create();
                        break;
                    case READ:
                        read();
                        break;
                    case UPDATE:
                        update();
                        break;
                    case LIST:
                        list();
                        break;
                    case HELP:
                        showHelp();
                        break;
                    case DELETE:
                        delete();
                        break;
                }
            } catch (Exception ex) {
                System.out.println("Произошла ошибка " + ex.toString());
            }
        }
    }

    private void read() throws Exception {
        String id = prompt("Идентификатор пользователя: ");
        User user_ = userController.readUser(id);
        System.out.println(user_);
    }

    private void delete() throws Exception {
        String userid = prompt("Идентификатор пользователя: ");
        userController.deleteUser(userid);
    }

    private void update() throws Exception {
        String userid = prompt("Идентификатор пользователя: ");
        String field_name = prompt("Какое поле (SURNAME,NAME,TELEPHONE): ");
        String param = null;
        if (Fields.valueOf(field_name) == Fields.TELEPHONE) {
            param = catchTelephone(param);
            if (param == null) {
                return;
            }
        } else {
            param = prompt("Введите на то что хотите изменить");
        }
        User _user = userController.readUser(userid);
        userController.updateUser(_user, Fields.valueOf(field_name.toUpperCase()), param);
    }

    public String catchTelephone(String telephone) throws Exception {
        while (true) {
            try {
                telephone = prompt("Введите номер телефона (Отказ введите 0): ");
                if (telephone.equals("0")) {
                    System.out.println("Вы отказались от ввода для изменения пользователя");
                    return null;
                }
                validate.checkNumber(telephone);
                return telephone;
            } catch (PhoneException ex) {
                System.out.println("Произошла ошибка " + ex.toString());
            }
        }
    }

    public LocalDate catchDOB() throws Exception {
        while (true) {
            try {
                var dob = prompt("Введите дату рождения <dd.mm.yyyy> (Отказ введите 0): ");
                if (dob.equals("0")) {
                    System.out.println("Вы отказались от ввода для изменения пользователя");
                    return null;
                }
                var parsedDOB = validate.checkDob(dob);
                return parsedDOB;
            } catch (DateTimeParseException ex) {
                System.out.println("Произошла ошибка " + ex.toString());
            }
        }
    }

    public Sex catchSex() throws Exception {
        while (true) {
            try {
                var sex = prompt("Введите пол: 'm' или 'f' (Отказ введите 0): ");
                if (sex.equals("0")) {
                    System.out.println("Вы отказались от ввода для изменения пользователя");
                    return null;
                }
                var parsedSex = validate.checkSex(sex);
                return parsedSex;
            } catch (SexException ex) {
                System.out.println("Произошла ошибка " + ex.toString());
            }
        }
    }

    private void list() throws Exception {
        for (User user : userController.getUsers()) {
            System.out.println(user);
        }
    }

    private void create() throws Exception {
        String firstName = prompt("Имя: ");
        String lastName = prompt("Фамилия: ");
        var dob = catchDOB();
        if (dob == null) {
            return;
        }
        String phone = null;
        phone = catchTelephone(phone);
        if (phone == null) {
            return;
        }
        var sex = catchSex();
        if (sex == null) {
            return;
        }
        userController.saveUser(new User(firstName, lastName, phone, dob, sex));
    }

    private void showHelp() {
        System.out.println("Список команд:");
        for (Commands c : Commands.values()) {
            System.out.println(c);
        }
    }

    private String prompt(String message) {
        Scanner in = new Scanner(System.in);
        System.out.print(message);
        return in.nextLine();
    }
}
