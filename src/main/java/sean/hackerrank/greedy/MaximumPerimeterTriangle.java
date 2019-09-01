package sean.hackerrank.greedy;

import java.util.Arrays;
import java.util.Optional;

// https://www.hackerrank.com/challenges/maximum-perimeter-triangle
public class MaximumPerimeterTriangle {

  static int[] maximumPerimeterTriangle(int[] sticks) {

    Arrays.sort(sticks);
    for (int i = sticks.length - 1; i >= 2; i--) {
      for (int j = i - 1; j >= 1; j--) {
        for (int k = j - 1; k >= 0; k--) {
          Optional<Triangle> optional = Triangle.fromLengths(sticks[i], sticks[j], sticks[k]);
          if (optional.isPresent()) {
            return optional.get().toArray();
          }
        }
      }
    }
    return new int[]{-1};
  }

  static class Triangle {

    final int longest;
    final int middle;
    final int shortest;

    int[] toArray() {
      return new int[]{shortest, middle, longest};
    }

    Triangle(int longest, int middle, int shortest) {
      this.longest = longest;
      this.middle = middle;
      this.shortest = shortest;
    }

    static Optional<Triangle> fromLengths(int l1, int l2, int l3) {
      if (l1 + l2 <= l3 || l2 + l3 <= l1 || l3 + l1 <= l2) {
        return Optional.empty();
      }
      int[] arr = {l1, l2, l3};
      Arrays.sort(arr);
      return Optional.of(new Triangle(arr[2], arr[1], arr[0]));
    }


  }

}
