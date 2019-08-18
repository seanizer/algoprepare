package sean.crackingTheCodingInterview.ch2LinkedLists;

import java.util.ConcurrentModificationException;
import java.util.Iterator;

public class DoublyLinkedList<T> implements Iterable<T> {

  int modCount = 0;
  private int size = 0;
  private Node<T> beginning;
  private Node<T> end;

  @Override
  public Iterator<T> iterator() {
    return new Iterator<T>() {
      int localModCount = modCount;
      Node<T> current = beginning;

      void sanityCheck() {
        if (localModCount != modCount) {
          throw new ConcurrentModificationException();
        }
      }

      @Override
      public boolean hasNext() {
        sanityCheck();
        return false;
      }

      @Override
      public T next() {
        return null;
      }
    };
  }

  public void append(T item) {
    if (end == null) {
      end = new Node<>(item);
      beginning = end;
    }
    end.next = new Node<>(item);
    this.size++;
    modCount++;
  }

  public void prepend(T item) {
    if (beginning == null) {
      beginning = new Node<>(item);
      end = beginning;
    }

    Node<T> node = new Node<>(item);
    node.next = beginning;
    beginning = node;
    this.size++;
    modCount++;
  }

  static class Node<T> {

    private Node<T> next;
    private Node<T> previous;
    private T value;

    Node(T value) {
      this.value = value;
    }
  }

}
