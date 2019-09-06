package sean.hackerrank.warmup;

import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;
import static sean.hackerrank.warmup.CompareTriplets.compareTriplets;

import org.junit.jupiter.api.Test;

class CompareTripletsTest {

  @Test
  void sampleInput0() {
    assertThat(compareTriplets(asList(5, 6, 7), asList(3, 6, 10))).containsExactly(1, 1);
  }

  @Test
  void sampleInput1() {
    assertThat(compareTriplets(asList(17, 28, 30), asList(99, 16, 8))).containsExactly(2, 1);
  }
}