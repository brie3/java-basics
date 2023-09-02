package packages.GoodsStore;

import java.util.regex.Pattern;

import packages.GoodsStore.Exceptions.Credentials;
import packages.GoodsStore.Exceptions.Digit;
import packages.GoodsStore.Exceptions.Weight;

public class Entry implements Comparable<Entry> {
    private Pattern wordReg = Pattern.compile("^[a-zA-Zа-яА-Я]{2,}$");
    private Pattern digitReg = Pattern.compile("^[0-9]+$");
    private Pattern weigthReg = Pattern.compile("^[1-9][0-9]?$|^100$");

    private Integer id = 0;
    private String name = "";
    private Integer quantity = 1;
    private Integer winWeight = 100;

    public Entry(String id, String name, String quantity, String winWeight) throws Exception {
        SetID(id);
        SetName(name);
        SetQuantity(quantity);
        SetWinWeight(winWeight);
    }

    public Entry(String name, String quantity, String winWeight) throws Exception {
        SetName(name);
        SetQuantity(quantity);
        SetWinWeight(winWeight);
    }

    public Entry(Integer id, String name, Integer quantity, Integer winWeight) throws Exception {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.winWeight = winWeight;
    }

    public void SetID(String s) throws Digit {
        if (!digitReg.matcher(s).matches()) {
            throw new Digit("id must be of type unsigned integer e.g. 0123456789");
        }
        this.id = Integer.parseInt(s);
    }

    public void SetID(Integer id) {
        this.id = id;
    }

    public void SetName(String s) throws Credentials {
        if (!wordReg.matcher(s).matches()) {
            throw new Credentials("name must consist of only at least 2 letters");
        }
        this.name = s;
    }

    public void SetWinWeight(String s) throws Weight {
        if (!weigthReg.matcher(s).matches()) {
            throw new Weight("win weight must be of type integer expressing winning percentage 1-100.");
        }
        this.winWeight = Integer.parseInt(s);
    }

    public void SetQuantity(String s) throws Digit {
        if (!digitReg.matcher(s).matches()) {
            throw new Digit("quantity must be of type unsigned integer e.g. 0123456789");
        }
        this.quantity = Integer.parseInt(s);
    }

    public void SetQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Integer GetID() {
        return id;
    }

    public String GetName() {
        return name;
    }

    public Integer GetQuantity() {
        return this.quantity;
    }

    public Integer GetWinWeight() {
        return this.winWeight;
    }

    public boolean equals(Entry entry) {
        return id.equals(entry.id) &&
                name.equals(entry.name) &&
                quantity.equals(entry.quantity) &&
                winWeight.equals(entry.winWeight);
    }

    @Override
    public int compareTo(Entry other) {
        if (this.winWeight < other.GetWinWeight()) {
            return 1;
        }
        if (this.winWeight > other.GetWinWeight()) {
            return -1;
        }
        return 0;
    }

    @Override
    public String toString() {
        return String.format("%s,%s,%s,%s", Integer.toString(id), name, Integer.toString(quantity),
                Integer.toString(winWeight));
    }

    public static Entry fromString(String s) throws Exception {
        String[] line = s.split(",");
        return new Entry(line[0], line[1], line[2], line[3]);
    }
}
