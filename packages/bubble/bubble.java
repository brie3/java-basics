package packages.bubble;

import java.util.logging.*;
import java.util.*;

public class bubble {
    public bubble(int[] arr) {
        var l = Logger.getLogger("bubble");
        FileHandler fh = null;
        try {
            fh = new FileHandler("./bubble.log");
        } catch (Exception e) {
            System.out.println(e);
        }
        fh.setFormatter(new SimpleFormatter());
        l.addHandler(fh);
        l.info(Arrays.toString(arr));
        int n = arr.length;
        int temp = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < (n - i); j++) {
                if (arr[j - 1] > arr[j]) {
                    temp = arr[j - 1];
                    arr[j - 1] = arr[j];
                    arr[j] = temp;
                    l.info(Arrays.toString(arr));
                }
            }
        }
    };
}
