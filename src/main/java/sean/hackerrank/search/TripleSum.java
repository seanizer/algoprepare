package sean.hackerrank.search;

import java.util.Arrays;

// https://www.hackerrank.com/challenges/triple-sum
public class TripleSum {

  static long triplets(int[] a_in, int[] b_in, int[] c_in) {

    int[] a = sortAndRemoveDupes(a_in);
    int[] b = sortAndRemoveDupes(b_in);
    int[] c = sortAndRemoveDupes(c_in);

    long result = 0L;
    int leftPointer = -1;
    int rightPointer = -1;
    for (int middle : b) {
      leftPointer = movePointerForward(a, leftPointer, middle);
      rightPointer = movePointerForward(c, rightPointer, middle);
      if (leftPointer >= 0 && rightPointer >= 0) {
        result += (long) (leftPointer + 1) * (long) (rightPointer + 1);
      }
    }
    return result;


  }

  private static int movePointerForward(int[] arr, int pointer, int referenceValue) {
    while (pointer < 0 || arr[pointer] <= referenceValue) {
      pointer++;
      if (pointer == arr.length || arr[pointer] > referenceValue) {
        pointer--;
        break;
      }
    }
    return pointer;
  }

  private static int[] sortAndRemoveDupes(int[] input) {
    return Arrays.stream(input).sorted().distinct().toArray();
  }

}
