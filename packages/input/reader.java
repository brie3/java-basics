package packages.input;

import java.io.*;
import java.util.regex.*;

public class reader {
    Pattern word = Pattern.compile("^[a-zA-Z]*$");
    Pattern digit = Pattern.compile("\\d+");
    Console inputReader = null;

    public reader(Console console) {
        inputReader = console;
    }

    public line read(String text, type t) {
        var input = inputReader.readLine(text);
        switch (t) {
            case Int:
                if (!digit.matcher(input).matches()) {
                    return new line(type.Err, "input must be of type integer");
                }
                return new line(type.Str, input);
            case Str:
                if (!word.matcher(input).matches()) {
                    return new line(type.Err, "input must be of type string");
                }
                return new line(type.Str, input);
            default:
                return new line(type.Err, "unprocessable type: " + t);
        }
    }
}
