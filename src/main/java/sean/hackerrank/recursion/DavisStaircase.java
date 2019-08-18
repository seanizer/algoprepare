package sean.hackerrank.recursion;

import java.util.HashMap;
import java.util.Map;

// https://www.hackerrank.com/challenges/ctci-recursive-staircase
public class DavisStaircase {

  static int stepPerms(int n) {
    Map<Integer, Integer> cache = new HashMap<>();
    return calc(n, cache);
  }

  private static int calc(int n, Map<Integer, Integer> cache) {
    if (cache.containsKey(n)) {
      return cache.get(n);
    } else {
      final int result;
      switch (n) {
        case 0:
        case 1:
        case 2:
          result = n;
          break;
        case 3:
          result = 4;
          break;
        default:
          result = calc(n - 1, cache) + calc(n - 2, cache) + calc(n - 3, cache);
          break;
      }
      cache.put(n, result);
      return result;
    }
  }
}
