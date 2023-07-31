package packages.user.utils;

import java.util.Locale;
import java.time.format.*;
import java.time.LocalDate;

import packages.user.model.Sex;

public class Validate {

    public void checkNumber(String telephone) throws Exception {
        if (!telephone.substring(0, 1).equals("+")) {
            throw new PhoneException("Ошибка телефон начинается с плюсика");
        } else if (telephone.length() != 12) {
            throw new PhoneException("Длина телефона должна быть 11");
        }
    }

    public LocalDate checkDob(String dob) throws Exception {
        return LocalDate.parse(dob, DateTimeFormatter.ofPattern("dd.MM.yyyy").withLocale(Locale.US));
    }

    public Sex checkSex(String sex) throws Exception {
        var parsedSex = Sex.fromString(sex);
        if (parsedSex == Sex.UNSPECIFIED) {
            throw new SexException("пол должен быть 'm' или 'f'");
        }
        return parsedSex;
    }
}
