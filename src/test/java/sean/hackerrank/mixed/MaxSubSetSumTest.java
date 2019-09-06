package sean.hackerrank.mixed;

import static org.assertj.core.api.Assertions.assertThat;
import static sean.hackerrank.mixed.MaxSubSetSum.maxSubsetSum;
import static sean.util.ArrayHelper.arr;
import static sean.util.FileHelper.intArrayFromFile;

import org.junit.jupiter.api.Test;

class MaxSubSetSumTest {


  @Test
  void sampleInput0() {
    assertThat(maxSubsetSum(arr(3, 7, 4, 6, 5))).isEqualTo(13);
  }

  @Test
  void sampleInput1() {
    assertThat(maxSubsetSum(arr(3, 5, -7, 8, 10))).isEqualTo(15);
  }

  @Test
  void testCase8() {
    assertThat(maxSubsetSum(intArrayFromFile("maxSubSetSum8.txt"))).isEqualTo(76497274);
  }

  @Test
  void testCase9() {
    assertThat(maxSubsetSum(intArrayFromFile("maxSubSetSum9.txt"))).isEqualTo(81660407);
  }

  @Test
  void testCase11() {
    assertThat(maxSubsetSum(intArrayFromFile("maxSubSetSum11.txt"))).isEqualTo(65027214);
  }


}