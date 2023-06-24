package packages.notebook;

import java.util.*;

public class util {
    public static ArrayList<notebook> gen(int num) {
        var rand = new Random(System.currentTimeMillis());
        var out = new ArrayList<notebook>(num);
        for (int i = 0; i < num; i++) {
            var ramBytes = rand.nextInt(1000);
            var hdBytes = rand.nextInt(1000);
            var osPick = os.values()[rand.nextInt(os.values().length - 1)];
            var colorPick = color.values()[rand.nextInt(color.values().length - 1)];
            if (osPick == os.MacOS) {
                out.add(new macos(colorPick, hdBytes, ramBytes));
            } else {
                out.add(new pc(colorPick, osPick, hdBytes, ramBytes));
            }
        }
        return out;
    }
}
