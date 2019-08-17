package sean.hackerrank.warmup;

import java.util.Arrays;

// https://www.hackerrank.com/challenges/mini-max-sum
public class MiniMaxSum {
    static void miniMaxSum(int[] arr) {

        Arrays.sort(arr);

        long min = Arrays.stream(arr, 0, 4).mapToLong(Long::valueOf).sum();
        long max = Arrays.stream(arr, arr.length - 4, arr.length).mapToLong(Long::valueOf).sum();


        System.out.printf("%d %d%n", min, max);


    }
}
