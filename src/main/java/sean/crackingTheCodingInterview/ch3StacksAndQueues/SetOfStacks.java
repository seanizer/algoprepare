package sean.crackingTheCodingInterview.ch3StacksAndQueues;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public interface SetOfStacks<T> {

  static <T> SetOfStacks<T> getWithCapacity(int capacity) {
    return new Solution<>(capacity);
  }

  void push(T item);

  Optional<T> pop();

  class Solution<T> implements SetOfStacks<T> {

    private final int capacity;
    List<T[]> storage = new ArrayList<>();
    private int offset = -1;

    public Solution(int capacity) {

      this.capacity = capacity;
    }

    @Override
    public void push(T item) {
      Objects.requireNonNull(item, "Null elements not allowed");
      int nextOffset = offset + 1;
      int arrayOffset = nextOffset / capacity;
      if (arrayOffset == storage.size()) {
        @SuppressWarnings("unchecked") T[] arr = (T[]) new Object[capacity];
        storage.add(arr);
      }
      storage.get(arrayOffset)[nextOffset % capacity] = item;
      offset++;
    }

    @Override
    public Optional<T> pop() {
      if (offset == -1) {
        return Optional.empty();
      }
      int arrayOffset = offset % capacity;
      T value = storage.get(offset / capacity)[arrayOffset];
      if (arrayOffset == 0) {
        storage.remove(storage.size() - 1);
      }
      offset--;
      return Optional.of(value);
    }


  }
}
