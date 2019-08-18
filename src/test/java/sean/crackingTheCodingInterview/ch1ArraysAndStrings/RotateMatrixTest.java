package sean.crackingTheCodingInterview.ch1ArraysAndStrings;

import static org.assertj.core.api.Assertions.assertThat;
import static sean.crackingTheCodingInterview.ch1ArraysAndStrings.MatrixHelper.drawMatrix;
import static sean.crackingTheCodingInterview.ch1ArraysAndStrings.MatrixHelper.row;
import static sean.crackingTheCodingInterview.ch1ArraysAndStrings.MatrixHelper.rows;
import static sean.crackingTheCodingInterview.ch1ArraysAndStrings.RotateMatrix.rotateClockwise;

import java.util.Arrays;
import org.junit.jupiter.api.Test;

class RotateMatrixTest {

  @Test
  void rotate4() {

    assertRotate(
        rows(
            row(1, 2, 3, 4),
            row(5, 6, 7, 8),
            row(9, 10, 11, 12),
            row(13, 14, 15, 16)
            ),
        rows(
            row(13, 9, 5, 1),
            row(14, 10, 6, 2),
            row(15, 11, 7, 3),
            row(16, 12, 8, 4)
            )
                );

  }

  @Test
  void rotate7() {

    assertRotate(
        rows(
            row(1, 2, 3, 4, 5, 6, 7),
            row(8, 9, 10, 11, 12, 13, 14),
            row(15, 16, 17, 18, 19, 20, 21),
            row(22, 23, 24, 25, 26, 27, 28),
            row(29, 30, 31, 32, 33, 34, 35),
            row(36, 37, 38, 39, 40, 41, 42),
            row(43, 44, 45, 46, 47, 48, 49)
            ),
        rows(
            row(43, 36, 29, 22, 15, 8, 1),
            row(44, 37, 30, 23, 16, 9, 2),
            row(45, 38, 31, 24, 17, 10, 3),
            row(46, 39, 32, 25, 18, 11, 4),
            row(47, 40, 33, 26, 19, 12, 5),
            row(48, 41, 34, 27, 20, 13, 6),
            row(49, 42, 35, 28, 21, 14, 7)
            )
                );

  }

  private void assertRotate(int[][] input, int[][] expectedOutput) {
    int[][] copy = input.clone();
    for (int i = 0; i < copy.length; i++) {
      copy[i] = copy[i].clone();
    }
    rotateClockwise(input);
    assertThat(
        Arrays.deepEquals(input, expectedOutput))
        .describedAs("Arrays.deepEquals(%s, %s)",
                     drawMatrix(input),
                     drawMatrix(expectedOutput)
                    ).isTrue();
  }

}