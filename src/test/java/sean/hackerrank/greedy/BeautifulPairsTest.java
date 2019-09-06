package sean.hackerrank.greedy;

import static org.assertj.core.api.Assertions.assertThat;
import static sean.hackerrank.greedy.BeautifulPairs.beautifulPairs;
import static sean.util.ArrayHelper.arr;

import org.junit.jupiter.api.Test;
import sean.util.FileHelper;

class BeautifulPairsTest {

  @Test
  void sampleInput0() {
    assertThat(beautifulPairs(arr(1, 2, 3, 4), arr(1, 2, 3, 3))).isEqualTo(4);
  }

  @Test
  void sampleInput1() {
    assertThat(beautifulPairs(arr(3, 5, 7, 11, 5, 8), arr(5, 7, 11, 10, 5, 8))).isEqualTo(6);
  }

  @Test
  void testCase4() {
    int[][] input = FileHelper.intArraysFromFile("beautifulPairs.txt");
    assertThat(beautifulPairs(input[0], input[1])).isEqualTo(999);
  }
}