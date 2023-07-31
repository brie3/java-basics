package hws.exceptions.hw2;

import packages.input.reader;
import packages.input.type;

public class task1 {
    public task1() {
        var input = new reader(System.console());
        while (true) {
            var line = input.read("\nВведите дробное число (типа float, например: '123.45').\n", type.Float);
            if (line.type() == type.Err) {
                System.out.println(line.String());
                continue;
            }
            float parsedInput = Float.parseFloat(line.String());
            System.out.printf("Вы ввели: %1.2f%n", parsedInput);
            break;
        }
    }
}
