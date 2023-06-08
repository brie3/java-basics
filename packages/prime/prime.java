package packages.prime;

import java.util.*;

public class prime {
    private int[] n;

    public prime(int n) {
        if (n < 2) {
            this.n = new int[] {};
            return;
        }
        List<Integer> list = new ArrayList<Integer>();
        list.add(2);
        HashMap<Integer, Boolean> sieve = new HashMap<Integer, Boolean>();
        for (int i = 3; i <= n; i += 2) {
            if (sieve.containsKey(i))
                continue;
            list.add(i);
            for (int j = i * i; j <= n; j += i) {
                sieve.put(j, true);
            }
        }
        this.n = list.stream().mapToInt(i -> i).toArray();
    }

    public int[] value() {
        return this.n;
    }
}
