package sean.hackerrank.arrays;

// https://www.hackerrank.com/challenges/crush
public class ArrayQuery {

  static long arrayManipulation(int n, int[][] queries) {

    long[] start = new long[n + 1];
    long[] end = new long[n + 1];

    for (int i = 0; i < queries.length; i++) {
      int[] line = queries[i];
      int a = line[0];
      int b = line[1];
      long k = line[2];

      start[a] += k;
      end[b] += k;
    }

    long sum = 0L;
    long max = -1L;

    for (int i = 1; i < n + 1; i++) {
      sum += start[i];

      if (sum > max) {
        max = sum;
      }

      sum -= end[i];
    }

    return max;

  }
}
