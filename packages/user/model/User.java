package packages.user.model;

import java.time.LocalDate;

public class User {
    private String id = "";
    private String firstName;
    private String lastName;
    private String phone;
    private LocalDate dob = null;
    private Sex sex = Sex.UNSPECIFIED;

    public User(String firstName, String lastName, String phone, LocalDate dob, Sex sex) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.dob = dob;
        this.sex = sex;
    }

    public User(String id, String firstName, String lastName, String phone, LocalDate dob, Sex sex) {
        this(firstName, lastName, phone, dob, sex);
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public LocalDate getDOB() {
        return dob;
    }

    public void setDOB(LocalDate dob) {
        this.dob = dob;
    }

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return String.format("Идентафикатор: %s Имя: %s, Фамилия: %s, Телефон: %s, Дата рождения: %s, Пол: %s", id,
                firstName, lastName, phone, dob, sex);
    }
}
