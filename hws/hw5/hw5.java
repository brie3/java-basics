package hws.hw5;

import packages.input.reader;
import packages.input.type;
import packages.phonebook.phonebook;

public class hw5 {

    public static void main(String[] args) {
        var input = new reader(System.console());
        var phonebook = new phonebook();
        while (true) {
            var line = input.read("\n1) Добавить контакт\n2) Вывести всех\n3) Выход\n", type.Int);
            if (line.type() == type.Err) {
                System.out.println(line.String());
                continue;
            }
            var option = Integer.parseInt(line.String());
            switch (option) {
                case 3:
                    return;
                case 2:
                    System.out.println(phonebook.fetchAll());
                    break;
                case 1:
                    var notAdded = true;
                    while (notAdded) {
                        line = input.read("\nВведите имя\n", type.Str);
                        if (line.type() == type.Err) {
                            System.out.println(line.String());
                            continue;
                        }
                        var name = line.String();
                        while (true) {
                            line = input.read("\nВведите номер\n", type.Int);
                            if (line.type() == type.Err) {
                                System.out.println(line.String());
                                continue;
                            }
                            line = phonebook.addPhone(name, Long.parseLong(line.String()));
                            System.out.println(line.String());
                            notAdded = false;
                            break;
                        }
                    }
                    break;
            }
        }
    }
}
