package sean.hackerrank.arrays;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static sean.hackerrank.arrays.RotLeft.rotLeft;

class RotLeftTest {

    static int[] arr(int... elements) {
        return elements;
    }

    @ParameterizedTest
    @EnumSource(Scenario.class)
    void rotLeftTest(Scenario scenario) {
        int[] rotated = rotLeft(scenario.input(), scenario.rotations);
        assertThat(rotated).containsExactly(scenario.output());
    }

    private enum Scenario {
        TWO(1, arr(1, 2), arr(2, 1)),
        EXAMPLE(4, arr(1, 2, 3, 4, 5), arr(5, 1, 2, 3, 4));
        private final int rotations;
        private final int[] _in;
        private final int[] _out;

        Scenario(int rotations, int[] _in, int[] _out) {
            this.rotations = rotations;
            this._in = _in;
            this._out = _out;
        }

        int[] input() {
            return Arrays.copyOf(_in, _in.length);
        }

        int[] output() {
            return Arrays.copyOf(_out, _out.length);
        }
    }

}