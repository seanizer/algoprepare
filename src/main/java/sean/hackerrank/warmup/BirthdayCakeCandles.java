package sean.hackerrank.warmup;

import java.util.NavigableMap;
import java.util.TreeMap;

// https://www.hackerrank.com/challenges/birthday-cake-candles
public class BirthdayCakeCandles {

  static int birthdayCakeCandles(int[] ar) {

    NavigableMap<Integer, Integer> map = new TreeMap<>();
    for (int i : ar) {
      map.put(i, map.getOrDefault(i, 0) + 1);
    }

    return map.lastEntry().getValue();


  }

}
