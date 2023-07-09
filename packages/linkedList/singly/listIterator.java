package packages.linkedList.singly;

import java.util.Iterator;

import packages.linkedList.linkedList;

public class listIterator<T> implements Iterator<T> {
    int index;
    linkedList<T> list;

    public listIterator(linkedList<T> list) {
        this.list = list;
        this.index = 0;
    }

    @Override
    public boolean hasNext() {
        return index < list.size();
    }

    @Override
    public T next() {
        return list.get(index);
    }
}
