package sean.hackerrank.hash;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// https://www.hackerrank.com/challenges/ctci-ransom-note
public class RansomNote {

  static void checkMagazine(String[] magazine, String[] note) {
    String result = doCheckMagazine(magazine, note);
    System.out.println(result);

  }

  static String doCheckMagazine(String[] magazine, String[] note) {
    String result = "Yes";
    MultiSet<String> ms = new MultiSet<>();
    ms.addAll(Arrays.asList(magazine));
    for (String word : note) {
      if (!ms.removeOne(word)) {
        result = "No";
        break;
      }
    }
    return result;
  }

  static class MultiSet<T> {

    private final Map<T, Integer> map = new HashMap<>();

    public void addAll(List<T> items) {
      for (T item : items) {
        int value = (map.getOrDefault(item, 0)) + 1;
        map.put(item, value);
      }
    }

    public boolean removeOne(T item) {
      if (map.containsKey(item)) {
        int value = map.get(item);
        if (value == 1) {
          map.remove(item);
        } else {
          map.put(item, value - 1);
        }
        return true;
      }
      return false;
    }
  }
}
