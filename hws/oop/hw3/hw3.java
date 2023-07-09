package hws.oop.hw3;

import java.util.HashSet;
import java.util.*;

import packages.drag.Component;
import packages.drag.Pharmacy;
import packages.drag.components.Borolgin;
import packages.drag.components.Penicillin;
import packages.drag.components.Spirit;

public class hw3 {
    public static void main(String[] args) {
        var list = new ArrayList<Component>();
        list.add(new Penicillin("penicillin", "1.0", 1));
        list.add(new Borolgin("borolgin", "2.0", 2));
        list.add(new Spirit("spirit", "3.0", 3));

        var result = new HashSet<>();
        result.add(new Pharmacy(list));
        result.add(new Pharmacy(list));
        result.add(new Pharmacy(list));
        System.out.println(result.size()); // 1
    }
}
