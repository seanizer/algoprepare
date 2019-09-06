package sean.hackerrank.warmup;

import static org.assertj.core.api.Assertions.assertThat;
import static sean.hackerrank.warmup.BirthdayCakeCandles.birthdayCakeCandles;
import static sean.util.ArrayHelper.arr;

import org.junit.jupiter.api.Test;

class BirthdayCakeCandlesTest {

  @Test
  void sampleInput0() {
    assertThat(birthdayCakeCandles(arr(3, 2, 1, 3))).isEqualTo(2);
  }

}