package sean.hackerrank.dp;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.LongStream;

// https://www.hackerrank.com/challenges/decibinary-numbers
public class Decibinary {

  static Map<String, Long> deciStringToBinaryValueMap = new HashMap<>();
  static final Comparator<String> COMPARATOR = Comparator.<String, Long>comparing(
      s -> deciStringToDeciBinaryValue(s))
      .thenComparing(Integer::parseInt, Comparator.reverseOrder());
  static Map<Long, String> longToDeciStringMap = new HashMap<>();

  static long deciStringToDeciBinaryValue(String s) {
    return deciStringToBinaryValueMap.computeIfAbsent(s, (str -> {
      long result = 0;
      int multiplier = 1;
      for (int i = str.length() - 1; i >= 0; i--) {
        result += (str.charAt(i) - '0') * multiplier;
        multiplier *= 2;
      }
      return result;
    }));
  }


  public static void main(String[] args) {
    AtomicInteger counter = new AtomicInteger();
    LongStream.range(0, 400)
              .mapToObj(String::valueOf)
              .sorted(COMPARATOR)
              .map(s -> String.format("(%s) Str: %s, v: %s", counter.incrementAndGet(), s,
                                      deciStringToDeciBinaryValue(s)))
              .forEach(System.out::println);
  }

  static String longToDeciString(long value) {
    return longToDeciStringMap.computeIfAbsent(value, Object::toString);
  }
}
