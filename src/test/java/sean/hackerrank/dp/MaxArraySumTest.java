package sean.hackerrank.dp;

import static org.assertj.core.api.Assertions.assertThat;
import static sean.hackerrank.dp.MaxArraySum.maxSubsetSum;
import static sean.util.ArrayHelper.arr;

import org.junit.jupiter.api.Test;
import sean.util.FileHelper;

class MaxArraySumTest {

  @Test
  void sampleInput1() {
    assertThat(maxSubsetSum(arr(2, 1, 5, 8, 4))).isEqualTo(11);
  }

  @Test
  void sampleInput2() {
    assertThat(maxSubsetSum(arr(3, 5, -7, 8, 10))).isEqualTo(15);
  }

  @Test
  void testCase3() {
    assertThat(maxSubsetSum(FileHelper.intArrayFromFile("maxArraySum1.txt"))).isEqualTo(107352889);

  }

  @Test
  void testCase30() {
    assertThat(maxSubsetSum(arr(3, 7, 4, 6, 5))).isEqualTo(13);

  }

}