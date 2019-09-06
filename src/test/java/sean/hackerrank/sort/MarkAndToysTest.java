package sean.hackerrank.sort;

import static org.assertj.core.api.Assertions.assertThat;
import static sean.hackerrank.sort.MarkAndToys.maximumToys;
import static sean.util.ArrayHelper.arr;

import org.junit.jupiter.api.Test;

class MarkAndToysTest {

  @Test
  void sampleInput() {
    assertThat(maximumToys(arr(1, 12, 5, 111, 200, 1000, 10), 50)).isEqualTo(4);
  }

}