package sean.hackerrank.sort;

import static org.assertj.core.api.Assertions.assertThat;
import static sean.hackerrank.sort.FraudulentActivityNotifications.activityNotifications;
import static sean.util.ArrayHelper.arr;

import org.junit.jupiter.api.Test;

class FraudulentActivityNotificationsTest {

  @Test
  void sampleInput0() {
    assertThat(activityNotifications(arr(2, 3, 4, 2, 3, 6, 8, 4, 5), 5)).isEqualTo(2);
  }

  @Test
  void sampleInput1() {
    assertThat(activityNotifications(arr(1, 2, 3, 4, 4), 4)).isEqualTo(0);
  }

  @Test
  void sampleInput2() {
    assertThat(activityNotifications(arr(10, 20, 30, 40, 50), 3)).isEqualTo(1);
  }

}