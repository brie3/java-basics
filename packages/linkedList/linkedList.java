package packages.linkedList;

public interface linkedList<T> extends Iterable<T> {
    void pushFront(T data);

    void pushBack(T data);

    void remove(int index);

    T get(int index);

    int size();

    void update(int index, T t);

    void join(linkedList<T> t);
}
