package sean.hackerrank.dp;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class CandiesTest {

  static long callCandies(int... arr) {
    return Candies.candies(arr.length, arr);
  }

  @Test
  void sampleInput1() {
    assertThat(callCandies(2, 4, 2, 6, 1, 7, 8, 9, 2, 1)).isEqualTo(19L);
  }

}