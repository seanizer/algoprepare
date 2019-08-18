package sean.crackingTheCodingInterview.ch2LinkedLists;

import java.util.Optional;

public class KthToLast {

  static <T> Optional<T> kthFromLast(LinkedList<T> list, int k) {
    Result<T> result = backTrack(list, k);
    if (result.offset == k) {
      return Optional.of(result.value);
    } else {
      return Optional.empty();
    }
  }

  private static <T> Result<T> backTrack(LinkedList<T> list, int k) {
    LinkedList<T> next = list.getNext();
    if (next == null) {
      return new Result<>(0, list.getValue());
    }
    Result<T> result = backTrack(next, k);
    if (result.offset == k) {
      return result;
    }
    return new Result<>(result.offset + 1, list.getValue());
  }

  static class Result<T> {

    final int offset;
    final T value;

    Result(int offset, T value) {
      this.offset = offset;
      this.value = value;
    }
  }
}
