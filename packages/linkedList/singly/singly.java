package packages.linkedList.singly;

import packages.linkedList.*;
import java.util.Iterator;

public class singly<T> implements linkedList<T> {
    node<T> head;
    int len = 0;

    public singly() {
        this.head = null;
    }

    public void pushFront(T data) {
        node<T> node = new node<>(data);
        if (this.head == null) {
            this.head = node;
        } else {
            node.next = head;
            head = node;
        }
        len++;
    }

    public void pushBack(T data) {
        node<T> node = new node<>(data);
        if (this.head == null) {
            this.head = node;
        } else {
            var x = head;
            while (x.next != null) {
                x = x.next;
            }
            x.next = node;
        }
        len++;
    }

    public T get(int i) {
        if (i < 0 || i >= len) {
            System.out.println("position unreachable");
            return null;
        }
        var x = head;
        for (; i > 0; i--) {
            x = x.next;
        }
        return x.data;
    }

    public int size() {
        return len;
    }

    public void remove(int i) {
        if (i < 0 || i >= len) {
            System.out.println("position unreachable");
            return;
        }
        var x = new node<T>(null);
        x.next = head;
        for (var j = i; j > 0; j--) {
            x = x.next;
        }
        x.next = x.next.next;
        if (i == 0) {
            head = x.next;
        }
        len--;
    }

    public void update(int i, T data) {
        if (i < 0 || i >= len) {
            System.out.println("position unreachable");
            return;
        }
        var x = head;
        for (; i > 0; i--) {
            x = x.next;
        }
        x.data = data;
    }

    public void join(linkedList<T> t) {
        for (var i = 0; i < t.size(); i++) {
            pushBack(t.get(i));
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new listIterator<T>(this);
    }

    @Override
    public String toString() {
        var out = "";
        for (var i = 0; i < size(); i++) {
            out += ", " + get(i);
        }
        return getClass() + "[" + out.substring(2) + "]";
    }
}
