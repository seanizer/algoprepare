package sean.hackerrank.greedy;

import static org.assertj.core.api.Assertions.assertThat;
import static sean.hackerrank.greedy.MinAbs.minimumAbsoluteDifference;
import static sean.util.ArrayHelper.arr;

import org.junit.jupiter.api.Test;

class MinAbsTest {

  @Test
  void sampleInput1() {
    assertThat(
        minimumAbsoluteDifference(arr(-59, -36, -13, 1, -53, -92, -2, -96, -54, 75))).isEqualTo(1);
  }

  @Test
  void sampleInput2() {
    assertThat(
        minimumAbsoluteDifference(arr(1, -3, 71, 68, 17))).isEqualTo(3);
  }

}