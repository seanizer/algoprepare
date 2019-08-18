package sean.crackingTheCodingInterview.ch2LinkedLists;

public class DeleteNode {

  static <T> void deleteNode(LinkedList<T> node) {
    LinkedList<T> next = node.getNext();
    if (next == null) {
      throw new UnsupportedOperationException();
    }
    node.setValue(next.getValue());
    node.setNext(next.getNext());
  }
}
