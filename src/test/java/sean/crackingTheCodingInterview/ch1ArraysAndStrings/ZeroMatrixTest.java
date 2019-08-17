package sean.crackingTheCodingInterview.ch1ArraysAndStrings;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static sean.crackingTheCodingInterview.ch1ArraysAndStrings.MatrixHelper.drawMatrix;
import static sean.crackingTheCodingInterview.ch1ArraysAndStrings.MatrixHelper.row;
import static sean.crackingTheCodingInterview.ch1ArraysAndStrings.MatrixHelper.rows;
import static sean.crackingTheCodingInterview.ch1ArraysAndStrings.ZeroMatrix.zeroMatrix;

class ZeroMatrixTest {


    @Test
    void tinyNoZero() {
        assertZeroMatrix(
                rows(row(1)),
                rows(row(1))
        );
    }

    @Test
    void tinyZero() {
        assertZeroMatrix(
                rows(row(0)),
                rows(row(0))
        );
    }

    @Test
    void smallZero() {
        assertZeroMatrix(
                rows(row(0, 1), row(1, 1)),
                rows(row(0, 0), row(0, 1))
        );
    }

    @Test
    void largish() {
        assertZeroMatrix(
                rows(
                        row(3, 2, 1, 0, 1, 2, 3),
                        row(4, 3, 2, 1, 2, 3, 4),
                        row(5, 4, 3, 2, 3, 4, 5),
                        row(6, 5, 4, 3, 4, 5, 6),
                        row(7, 6, 5, 4, 5, 6, 7),
                        row(8, 7, 6, 5, 6, 7, 8),
                        row(9, 8, 7, 6, 7, 8, 9)
                ),
                rows(
                        row(0, 0, 0, 0, 0, 0, 0),
                        row(4, 3, 2, 0, 2, 3, 4),
                        row(5, 4, 3, 0, 3, 4, 5),
                        row(6, 5, 4, 0, 4, 5, 6),
                        row(7, 6, 5, 0, 5, 6, 7),
                        row(8, 7, 6, 0, 6, 7, 8),
                        row(9, 8, 7, 0, 7, 8, 9)
                )
        );
    }


    private void assertZeroMatrix(int[][] input, int[][] expectedOutput) {
        int[][] copy = input.clone();
        for (int i = 0; i < copy.length; i++) {
            copy[i] = copy[i].clone();
        }
        zeroMatrix(input);
        assertThat(
                Arrays.deepEquals(input, expectedOutput))
                .describedAs("Arrays.deepEquals(%s, %s)",
                        drawMatrix(input),
                        drawMatrix(expectedOutput)
                ).isTrue();
    }


}