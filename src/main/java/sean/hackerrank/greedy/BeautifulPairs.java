package sean.hackerrank.greedy;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

// https://www.hackerrank.com/challenges/beautiful-pairs
public class BeautifulPairs {

  static int beautifulPairs(int[] a, int[] b) {
    Map<Integer, Integer> frequenciesA = countFrequencies(a);
    Map<Integer, Integer> frequenciesB = countFrequencies(b);
    int result = 0;
    int difference = 0;

    for (Map.Entry<Integer, Integer> entry : frequenciesA.entrySet()) {
      int freqA = entry.getValue();
      int key = entry.getKey();
      int freqB = firstNonNull(frequenciesB.remove(key), 0);
      result += Math.min(freqA, freqB);
      difference += Math.abs(freqA - freqB);
      if (freqB > 0) {
        frequenciesB.remove(key);
      }
    }

    for (int value : frequenciesB.values()) {
      difference += value;
    }

    if (difference > 1) {
      result++;
    } else if (result > 0) {
      result--;
    }

    return result;
  }

  private static <T> T firstNonNull(T first, T second) {
    if (first != null) {
      return first;
    }
    return Objects.requireNonNull(second);
  }

  private static Map<Integer, Integer> countFrequencies(int[] arr) {
    Map<Integer, Integer> map = new HashMap<>(arr.length);
    for (int i : arr) {
      map.compute(i, (k, v) -> (v == null ? 0 : v) + 1);
    }
    return map;
  }
}
