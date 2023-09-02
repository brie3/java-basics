package hws.toystore;

import packages.GoodsStore.GoodStore;

public class toystore {
    public static void main(String[] args) {
        var gs = new GoodStore(System.in, "toystore");
        gs.Run();
    }
}
