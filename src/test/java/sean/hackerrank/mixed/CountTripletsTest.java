package sean.hackerrank.mixed;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

class CountTripletsTest {

  @ParameterizedTest
  @EnumSource(Scenario.class)
  void testCountTriplets(Scenario scenario) {
    List<Long> longs = scenario.longs();
    long ratio = scenario.ratio;
    assertThat(CountTriplets.countTriplets(longs, ratio))
        .describedAs("List: %s, ratio: %s", longs, ratio)
        .isEqualTo(scenario.expectedResult);

  }

  private enum Scenario {
    EXAMPLE1(Arrays.asList(1, 2, 2, 4), 2, 2),
    EXAMPLE2(Arrays.asList(1, 3, 9, 9, 27, 81), 6, 3),
    HINT(Arrays.asList(1, 2, 1, 2, 4), 3, 2);
    private final List<Long> longs;
    private final long expectedResult;
    private final long ratio;

    Scenario(List<Integer> input, long expectedResult, long ratio) {
      this.longs = input.stream().map(Integer::longValue).collect(Collectors.toList());
      this.expectedResult = expectedResult;
      this.ratio = ratio;
    }

    public List<Long> longs() {
      return new ArrayList<>(longs);
    }
  }
}