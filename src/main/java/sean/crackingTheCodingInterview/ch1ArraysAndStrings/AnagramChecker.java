package sean.crackingTheCodingInterview.ch1ArraysAndStrings;

import java.util.Arrays;

public interface AnagramChecker {

  boolean isAnagram(String first, String second);

  class SortingAnagramChecker implements AnagramChecker {

    @Override
    public boolean isAnagram(String first, String second) {
      if (first.length() == second.length()) {
        char[] first_arr = first.toCharArray();
        char[] second_arr = second.toCharArray();
        Arrays.sort(first_arr);
        Arrays.sort(second_arr);
        return Arrays.equals(first_arr, second_arr);
      }
      return false;
    }
  }

  class CountingAnagramChecker implements AnagramChecker {

    @Override
    public boolean isAnagram(String first, String second) {
      if (first.length() == second.length()) {
        int[] counts = new int[256];
        for (int i = 0; i < first.length(); i++) {
          int n = first.charAt(i);
          counts = autoGrow(counts, n);
          counts[n]++;
        }
        for (int i = 0; i < second.length(); i++) {
          int n = second.charAt(i);
          if (counts.length < n || --counts[n] < 0) {
            return false;
          }
        }
        return true;
      }
      return false;
    }

    private int[] autoGrow(int[] arr, int offset) {
      if (arr.length > offset) {
        return arr;
      }
      int newSize = arr.length * 2;
      while (offset > newSize) {
        newSize *= 2;
      }
      return Arrays.copyOf(arr, newSize);
    }
  }
}
