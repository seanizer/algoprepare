package sean.hackerrank.mixed;

import java.util.AbstractSet;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

// https://www.hackerrank.com/challenges/max-array-sum
public class MaxSubSetSum {

  static int maxSubsetSum(int[] arr) {

    Map<String, Integer> sums = new HashMap<>();
    for (int i = 0; i < arr.length; i++) {
      int n = arr[i];
      Set<Integer> item = Collections.singleton(n);
    }
    return -1;
  }

  static <T> Set<T> addToSet(Set<T> set, T item) {
    if (set.isEmpty()) {
      return Collections.singleton(item);
    }
    if (set.contains(item)) {
      return set;
    }
    return new AbstractSet<T>() {
      @Override
      public Iterator<T> iterator() {
        return new Iterator<T>() {

          boolean first = true;
          Iterator<T> delegate = set.iterator();

          @Override
          public boolean hasNext() {
            return first || delegate.hasNext();
          }

          @Override
          public T next() {
            if (first) {
              first = false;
              return item;
            }
            return delegate.next();
          }
        };
      }

      @Override
      public int size() {
        return set.size() + 1;
      }
    };
  }


}
