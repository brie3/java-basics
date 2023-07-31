package hws.exceptions.hw2;

import packages.input.reader;
import packages.input.type;

public class task4 {
    public task4() throws Exception {
        var input = new reader(System.console());
        while (true) {
            var line = input.read("\nВведите пустую строку.\n", type.Str);
            if (line.type() == type.Err) {
                System.out.println(line.String());
                continue;
            }
            if (line.String().length() == 0) {
                throw new Exception("empty String");
            }
        }
    }
}
