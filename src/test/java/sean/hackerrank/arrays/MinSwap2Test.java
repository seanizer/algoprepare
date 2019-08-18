package sean.hackerrank.arrays;

import java.util.function.Supplier;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

class MinSwap2Test {

  @ParameterizedTest
  @EnumSource(Scenario.class)
  void calculateMinSwaps(Scenario scenario) {
    Assertions.assertThat(MinSwap2.minSwap(scenario.get())).isEqualTo(scenario.expectedSwaps);
  }

  private enum Scenario implements Supplier<int[]> {
    MINIMAL(0) {
      @Override
      public int[] get() {
        return Scenario.arr();
      }
    }, ONE(0) {
      @Override
      public int[] get() {
        return Scenario.arr(1);
      }
    },
    TWO_SORTED(0) {
      @Override
      public int[] get() {
        return Scenario.arr(1, 2);
      }
    },
    TWO_UNSORTED(1) {
      @Override
      public int[] get() {
        return Scenario.arr(2, 1);
      }
    }, THREE(1) {
      @Override
      public int[] get() {
        return Scenario.arr(3, 2, 1);
      }
    }, EXAMPLE(3) {
      @Override
      public int[] get() {
        return Scenario.arr(1, 3, 5, 2, 4, 6, 7);
      }
    }, MORE(5) {
      @Override
      public int[] get() {
        return Scenario.arr(10, 9, 8, 7, 6, 5, 4, 3, 2, 1);
      }
    };

    private final int expectedSwaps;

    Scenario(int expectedSwaps) {
      this.expectedSwaps = expectedSwaps;
    }

    private static int[] arr(int... items) {
      return items;
    }
  }

}