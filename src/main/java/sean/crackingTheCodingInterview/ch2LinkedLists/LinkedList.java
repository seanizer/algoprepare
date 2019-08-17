package sean.crackingTheCodingInterview.ch2LinkedLists;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedList<T> implements Iterable<T> {
    private T value;
    private LinkedList<T> next;

    public LinkedList(T value) {
        this.value = value;
    }

    public void dropNext() {
        if (next != null) next = next.next;
    }

    public void add(T value) {
        LinkedList<T> node = this;
        while (node.next != null) node = node.next;
        node.next = new LinkedList<>(value);
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public LinkedList<T> getNext() {
        return next;
    }

    public void setNext(LinkedList<T> next) {
        this.next = next;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            LinkedList<T> currentNode = LinkedList.this;
            T value = currentNode.value;

            @Override
            public boolean hasNext() {
                if (value == null && currentNode != null) {
                    currentNode = currentNode.next;
                    if (currentNode != null) value = currentNode.value;
                }
                return value != null;
            }

            @Override
            public T next() {
                if (!hasNext()) throw new NoSuchElementException();
                T temp = this.value;
                this.value = null;
                return temp;
            }
        };
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder().append('[');
        Iterator<T> iterator = iterator();
        if (iterator.hasNext()) {
            sb.append(iterator.next());
            while (iterator.hasNext()) sb.append(", ").append(iterator.next());
        }
        sb.append(']');
        return sb.toString();
    }

    public LinkedList<T> copy() {
        LinkedList<T> copy = new LinkedList<>(value);
        for (T value : next) {
            copy.add(value);
        }
        return copy;
    }
}
