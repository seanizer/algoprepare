package sean.crackingTheCodingInterview.ch3StacksAndQueues;

import java.util.Objects;
import java.util.Optional;

public interface MinStack<T extends Comparable<? super T>> {

  static <T extends Comparable<? super T>> MinStack<T> get() {
    return new StandardMinStack<>();
  }

  void push(T element);

  Optional<T> pop();

  Optional<T> min();

  class StandardMinStack<T extends Comparable<? super T>> implements MinStack<T> {

    Node<T> head;

    @Override
    public void push(T element) {
      Objects.requireNonNull(element, "No null values allowed");
      head = new Node<>(element, head);
    }

    @Override
    public Optional<T> pop() {
      if (head == null) {
        return Optional.empty();
      }
      T value = head.value;
      head = head.previous;
      return Optional.of(value);
    }

    @Override
    public Optional<T> min() {
      return Optional.ofNullable(head).map(n -> n.minValue);
    }

    static class Node<T extends Comparable<? super T>> {

      final Node<T> previous;
      final T value;
      final T minValue;

      Node(T value, Node<T> previous) {
        this.value = value;
        this.previous = previous;
        this.minValue =
            previous == null || previous.value.compareTo(value) > 0 ? value : previous.value;
      }
    }
  }
}
