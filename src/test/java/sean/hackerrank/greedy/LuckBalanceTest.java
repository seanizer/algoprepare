package sean.hackerrank.greedy;

import static org.assertj.core.api.Assertions.assertThat;
import static sean.hackerrank.greedy.LuckBalance.luckBalance;
import static sean.util.ArrayHelper.arr;

import org.junit.jupiter.api.Test;

class LuckBalanceTest {

  @Test
  void sampleInput() {
    assertThat(
        luckBalance(3,
                    arr(
                        arr(5, 1),
                        arr(2, 1),
                        arr(1, 1),
                        arr(8, 1),
                        arr(10, 0),
                        arr(5, 0))
                   )
              ).isEqualTo(29);
  }

}