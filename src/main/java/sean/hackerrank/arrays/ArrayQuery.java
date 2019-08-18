package sean.hackerrank.arrays;

// https://www.hackerrank.com/challenges/crush
public class ArrayQuery {

  static long arrayManipulation(int n, int[][] queries) {

    long[] arr = new long[n + 1];
    for (int[] query : queries) {
      int leftOffset = query[0] - 1;
      int rightOffset = query[1];
      int delta = query[2];
      arr[leftOffset] += delta;
      arr[rightOffset] -= delta;
    }
    long sum = 0;
    long max = 0;
    for (int i = 0; i < arr.length - 1; i++) {
      sum += arr[i];
      max = Math.max(max, sum);
    }
    return max;

  }
}
