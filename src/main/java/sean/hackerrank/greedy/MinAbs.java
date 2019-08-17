package sean.hackerrank.greedy;

import java.util.Arrays;

// https://www.hackerrank.com/challenges/minimum-absolute-difference-in-an-array
public class MinAbs {
    // Complete the minimumAbsoluteDifference function below.
    static int minimumAbsoluteDifference(int[] arr) {
        Arrays.sort(arr);
        int minAbs = Integer.MAX_VALUE;
        for (int i = 1; i < arr.length; i++) {
            int left = arr[i - 1];
            int right = arr[i];
            minAbs = Math.min(minAbs, Math.abs(left - right));
        }
        return minAbs;
    }

}
