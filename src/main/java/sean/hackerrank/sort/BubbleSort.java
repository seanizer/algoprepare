package sean.hackerrank.sort;

// https://www.hackerrank.com/challenges/ctci-bubble-sort
public class BubbleSort {

  static void countSwaps(int[] a) {

    int swaps = 0;

    for (int i = 0; i < a.length - 1; i++) {
      if (a[i] > a[i + 1]) {
        int temp = a[i + 1];
        a[i + 1] = a[i];
        a[i] = temp;
        swaps++;
        i = -1;
      }
    }

    System.out.printf("Array is sorted in %d swaps.%n", swaps);
    System.out.printf("First Element: %d%n", a[0]);
    System.out.printf("Last Element: %d%n", a[a.length - 1]);

  }


}
