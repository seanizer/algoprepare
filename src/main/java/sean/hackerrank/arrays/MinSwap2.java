package sean.hackerrank.arrays;

// https://www.hackerrank.com/challenges/minimum-swaps-2
public class MinSwap2 {
    public static int minSwap(int[] arr) {
        int first = 0;
        int last = arr.length - 1;
        int swaps = 0;
        while (first < last) {
            while (arr[first] == first + 1 && first < last) {
                first++;
            }
            if (first < last) {
                int temp = arr[arr[first] - 1];
                arr[arr[first] - 1] = arr[first];
                arr[first] = temp;
                swaps++;
            }
        }
        return swaps;
    }

    static void swap(int[] arr, int pos1, int pos2) {
        int tmp = arr[pos1];
        arr[pos1] = arr[pos2];
        arr[pos2] = tmp;
    }

}
