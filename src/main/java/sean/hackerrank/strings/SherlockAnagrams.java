package sean.hackerrank.strings;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

// https://www.hackerrank.com/challenges/sherlock-and-anagrams
public class SherlockAnagrams {

  static int sherlockAndAnagrams(String s) {
    MultiSet ms = new MultiSet();
    ms.addSubstrings(s);
    return ms.countPairs();
  }

  static class MultiSet {

    private final Map<String, Integer> map = new HashMap<>();

    private void addNormalized(String word) {
      char[] chars = word.toCharArray();
      Arrays.sort(chars);
      String sorted = new String(chars);
      int count = (map.getOrDefault(sorted, 0)) + 1;
      map.put(sorted, count);
    }

    public void addSubstrings(String word) {
      for (int start = 0; start < word.length(); start++) {
        for (int end = start + 1; end <= word.length(); end++) {
          String substring = word.substring(start, end);
          addNormalized(substring);
        }
      }
    }

    public int countPairs() {
      int pairs = 0;
      for (Integer count : map.values()) {
        if (count > 1) {
          int sum = 0;
          for (int i = 1; i < count; i++) {
            sum += i;
          }
          pairs += sum;
        }
      }

      return pairs;
    }
  }
}
