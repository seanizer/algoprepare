package sean.hackerrank.sort;

import static sean.hackerrank.sort.BubbleSort.countSwaps;
import static sean.util.ArrayHelper.arr;
import static sean.util.RunnableAssertions.assertThatOutputOf;

import org.junit.jupiter.api.Test;

class BubbleSortTest {

  @Test
  void sampleInput0() {
    assertThatOutputOf(() -> countSwaps(arr(1, 2, 3))).containsExactly(
        "Array is sorted in 0 swaps.",
        "First Element: 1",
        "Last Element: 3");
  }

  @Test
  void sampleInput1() {
    assertThatOutputOf(() -> countSwaps(arr(3, 2, 1))).containsExactly(
        "Array is sorted in 3 swaps.",
        "First Element: 1",
        "Last Element: 3");
  }

}