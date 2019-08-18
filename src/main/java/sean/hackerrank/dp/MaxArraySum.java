package sean.hackerrank.dp;

public class MaxArraySum {

  static int maxSubsetSum(int[] arr) {
    int[] max = new int[arr.length];
    int largest = 0;
    for (int i = 0; i < arr.length; i++) {
      int n = 0;
      if (i > 1) {
        n = Math.max(n, max[i - 2]);
      }
      if (i > 2) {
        n = Math.max(n, max[i - 3]);
      }
      n = Math.max(n, n + arr[i]);
      max[i] = n;
      largest = Math.max(largest, arr[i]);
    }
    int result = largest;
    for (int i = max.length - 2; i < max.length; i++) {
      result = Math.max(result, max[i]);
    }
    return result;
  }
}
