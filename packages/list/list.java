package packages.list;

import java.util.*;

public class list {
    private ArrayList<Integer> list = null;

    public list(Integer[] arr) {
        list = new ArrayList<>(Arrays.asList(arr));
    }

    public ArrayList<Integer> removeEven() {
        var it = list.iterator();
        while (it.hasNext()) {
            var i = it.next();
            if (i % 2 == 0) {
                it.remove();
            }
        }
        return list;
    }

    public Integer min() {
        var min = Integer.MAX_VALUE;
        for (Integer integer : list) {
            if (min > integer) {
                min = integer;
            }
        }
        return min;
    }

    public Integer max() {
        var max = Integer.MIN_VALUE;
        for (Integer integer : list) {
            if (max < integer) {
                max = integer;
            }
        }
        return max;
    }

    public Integer average() {
        var sum = 0;
        for (Integer integer : list) {
            sum += integer;
        }
        return sum / list.size();
    }
}
