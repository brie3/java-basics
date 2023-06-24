package packages.filter;

import java.io.*;
import java.util.ArrayList;

import packages.input.*;
import packages.notebook.notebook;
import packages.notebook.os;
import packages.notebook.color;

public class filter {
    PrintStream _stream = null;
    reader _reader = null;
    ArrayList<notebook> _db = null;

    public filter(PrintStream stream, Console console, ArrayList<notebook> db) {
        _db = db;
        _stream = stream;
        _reader = new reader(console);
        main();
    }

    void main() {
        while (true) {
            var line = _reader.read(
                    "\nВведите цифру, соответствующую необходимому критерию:\n1) - ОЗУ\n2) - Объем ЖД\n3) - Операционная система\n4) - Цвет\n5) - Выход\n",
                    type.Int);
            if (line.type() == type.Err) {
                System.out.println(line.String());
                continue;
            }
            switch (Integer.parseInt(line.String())) {
                case 1:
                    ram();
                    break;
                case 2:
                    hd();
                    break;
                case 3:
                    os();
                    break;
                case 4:
                    color();
                    break;
                case 5:
                    return;
            }
        }
    };

    void ram() {
        while (true) {
            var line = _reader.read("\nВведите диапазон значений:\nминимум:\n", type.Int);
            if (line.type() == type.Err) {
                System.out.println(line.String());
                continue;
            }
            var min = Long.parseLong(line.String());
            while (true) {
                line = _reader.read("\nмаксимум:\n", type.Int);
                if (line.type() == type.Err) {
                    System.out.println(line.String());
                    continue;
                }
                var max = Integer.parseInt(line.String());
                for (notebook note : _db) {
                    if (note.Ram() >= min && note.Ram() <= max) {
                        _stream.println(note);
                    }
                }
                return;
            }
        }
    };

    void hd() {
        while (true) {
            var line = _reader.read("\nВведите диапазон значений:\nминимум:\n", type.Int);
            if (line.type() == type.Err) {
                System.out.println(line.String());
                continue;
            }
            var min = Long.parseLong(line.String());
            while (true) {
                line = _reader.read("\nмаксимум:\n", type.Int);
                if (line.type() == type.Err) {
                    System.out.println(line.String());
                    continue;
                }
                var max = Integer.parseInt(line.String());
                for (notebook note : _db) {
                    if (note.HD() >= min && note.HD() <= max) {
                        _stream.println(note);
                    }
                }
                return;
            }
        }
    };

    void os() {
        while (true) {
            var line = _reader.read("\nВведите искомое значений: " + os.ToString() + "\n", type.Str);
            if (line.type() == type.Err) {
                System.out.println(line.String());
                continue;
            }
            var osPick = os.string(line.String());
            if (osPick == os.Unknown) {
                System.out.println(
                        "значение: " + line.String() + " - " + osPick.name().toLowerCase() + "\n");
                continue;
            }

            for (notebook note : _db) {
                if (note.OS() == osPick) {
                    _stream.println(note);
                }
            }
            return;
        }
    };

    void color() {
        while (true) {
            var line = _reader.read("\nВведите искомое значений: " + color.ToString() + "\n", type.Str);
            if (line.type() == type.Err) {
                System.out.println(line.String());
                continue;
            }
            var colorPick = color.string(line.String());
            if (colorPick == color.Unknown) {
                System.out.println(
                        "значение: " + line.String() + " - " + colorPick.name().toLowerCase() + "\n");
                continue;
            }
            for (notebook note : _db) {
                if (note.Color() == colorPick) {
                    _stream.println(note);
                }
            }
            return;
        }
    };
}
