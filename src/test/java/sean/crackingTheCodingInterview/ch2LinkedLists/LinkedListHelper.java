package sean.crackingTheCodingInterview.ch2LinkedLists;

public class LinkedListHelper {

  static <T> LinkedList<T> toLinkedList(T first, T... more) {
    LinkedList<T> list = new LinkedList<>(first);
    for (T t : more) {
      list.add(t);
    }
    return list;
  }
}
