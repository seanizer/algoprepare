package sean.hackerrank.recursion;

import static org.assertj.core.api.Assertions.assertThat;
import static sean.hackerrank.recursion.Fibonacci.fibonacci;

import java.util.LinkedHashMap;
import java.util.Map;
import org.junit.jupiter.api.Test;

class FibonacciTest {

  @Test
  void fib() {

    Map<Integer, Integer> map = new LinkedHashMap<>();

    map.put(0, 0);
    map.put(1, 1);
    map.put(2, 1);
    map.put(3, 2);
    map.put(4, 3);
    map.put(5, 5);
    map.put(6, 8);
    map.put(7, 13);
    map.put(8, 21);
    map.put(9, 34);
    map.put(10, 55);
    map.put(11, 89);
    map.put(12, 144);
    map.put(13, 233);
    map.put(14, 377);
    map.put(15, 610);
    map.put(16, 987);
    map.put(17, 1597);
    map.put(18, 2584);
    map.put(19, 4181);
    map.put(20, 6765);
    map.put(21, 10946);
    map.put(22, 17711);
    map.put(23, 28657);
    map.put(24, 46368);
    map.put(25, 75025);
    map.put(26, 121393);
    map.put(27, 196418);
    map.put(28, 317811);
    map.put(29, 514229);
    map.put(30, 832040);

    map.forEach((k, v) -> assertThat(fibonacci(k)).describedAs("fibonacci(%s)", k).isEqualTo(v));

  }

}