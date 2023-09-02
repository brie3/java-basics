package packages.GoodsStore.Repository;

import packages.GoodsStore.Entry;

public interface Repository {
    void Create(Entry entry);
    Entry GetRandom();
}
