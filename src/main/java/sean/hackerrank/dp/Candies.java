package sean.hackerrank.dp;

import java.util.Arrays;

// https://www.hackerrank.com/challenges/candies
public class Candies {

  static long candies(int n, int[] arr) {
    int[] candy = new int[arr.length];
    Arrays.fill(candy, 1);
    while (true) {
      if (!traverse(arr, candy)) {
        break;
      }
    }
    return Arrays.stream(candy).mapToLong(Long::valueOf).sum();
  }

  private static boolean traverse(int[] arr, int[] candy) {
    boolean changed = false;
    for (int i = 1; i < arr.length; i++) {
      int prevRating = arr[i - 1];
      int currentRating = arr[i];
      int prevCandy = candy[i - 1];
      int currentCandy = candy[i];
      while (prevRating < currentRating && !(currentCandy > prevCandy)) {
        candy[i]++;
        currentCandy++;
        changed = true;
      }
    }
    for (int i = arr.length - 2; i >= 0; i--) {
      int prevRating = arr[i + 1];
      int currRating = arr[i];
      int prevCandy = candy[i + 1];
      int currCandy = candy[i];
      while (prevRating < currRating && !(currCandy > prevCandy)) {
        candy[i]++;
        currCandy++;
        changed = true;
      }
    }
    return changed;
  }
}
