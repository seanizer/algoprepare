package sean.hackerrank.mixed;

// https://www.hackerrank.com/challenges/max-array-sum
public class MaxSubSetSum {

  static int maxSubsetSum(int[] arr) {

    arr[1] = Math.max(arr[0], arr[1]);
    for (int i = 2; i < arr.length; i++) {
      int current = arr[i];
      arr[i] = Math.max(current, Math.max(arr[i - 2] + current, arr[i - 1]));
    }

    return arr[arr.length - 1];
  }


}
