package sean.hackerrank.search;

import static org.assertj.core.api.Assertions.assertThat;
import static sean.hackerrank.search.MinimumTimeRequired.minTime;
import static sean.util.ArrayHelper.longArr;

import org.junit.jupiter.api.Test;
import sean.util.FileHelper;

class MinimumTimeRequiredTest {


  @Test
  void sampleInput0() {
    assertThat(minTime(longArr(2, 3), 5)).isEqualTo(6);
  }

  @Test
  void sampleInput1() {
    assertThat(minTime(longArr(1, 3, 4), 10)).isEqualTo(7);
  }

  @Test
  void sampleInput2() {
    assertThat(minTime(longArr(4, 5, 6), 12)).isEqualTo(20);
  }

  @Test
  void testCase9() {
    assertThat(
        minTime(FileHelper.stringToLongArray("minimumTimeRequired.txt"), 433551589L)).isEqualTo(
        269029389958L);
  }

}