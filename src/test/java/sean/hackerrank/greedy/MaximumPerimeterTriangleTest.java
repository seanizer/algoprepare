package sean.hackerrank.greedy;

import static org.assertj.core.api.Assertions.assertThat;
import static sean.hackerrank.greedy.MaximumPerimeterTriangle.maximumPerimeterTriangle;
import static sean.util.ArrayHelper.arr;

import org.junit.jupiter.api.Test;

class MaximumPerimeterTriangleTest {

  @Test
  void sampleInput0() {
    assertThat(maximumPerimeterTriangle(arr(1, 1, 1, 3, 3))).containsExactly(1, 3, 3);
  }

  @Test
  void sampleInput1() {
    assertThat(maximumPerimeterTriangle(arr(1, 2, 3))).containsExactly(-1);
  }

  @Test
  void sampleInput2() {
    assertThat(maximumPerimeterTriangle(arr(1, 1, 1, 2, 3, 5))).containsExactly(1, 1, 1);
  }
}