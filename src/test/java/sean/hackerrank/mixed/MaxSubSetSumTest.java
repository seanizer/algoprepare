package sean.hackerrank.mixed;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class MaxSubSetSumTest {
    @ParameterizedTest
    @EnumSource(Scenario.class)
    void subSetSumMax(Scenario scenario) {
        assertThat(MaxSubSetSum.maxSubsetSum(scenario.arr)).isEqualTo(scenario.expectation);
    }

    private enum Scenario {
        CASE1("3 7 4 6 5", 13);

        private final int[] arr;
        private final int expectation;

        Scenario(String input, int expectation) {
            this.arr = Arrays.stream(input.trim().split("\\s+")).mapToInt(Integer::parseInt).toArray();
            this.expectation = expectation;
        }
    }


}