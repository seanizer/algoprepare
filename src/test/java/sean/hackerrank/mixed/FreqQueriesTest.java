package sean.hackerrank.mixed;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

import java.util.List;

import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;

class FreqQueriesTest {

    static List<Integer> query(int operator, int operand) {
        return asList(operator, operand);
    }

    @SafeVarargs
    static List<List<Integer>> queries(List<Integer>... queries) {
        return asList(queries);
    }

    @ParameterizedTest
    @EnumSource(Scenario.class)
    void leFreak(Scenario scenario) {
        assertThat(FreqQueries.freqQuery(scenario.queries)).isEqualTo(scenario.expectedOutput);
    }


    private enum Scenario {
        FIRST_EXAMPLE(queries(
                query(1, 1),
                query(2, 2),
                query(3, 2),
                query(1, 1),
                query(1, 1),
                query(2, 1),
                query(3, 2)
        ), asList(0, 1)),
        LARGER(queries(
                query(1, 3),
                query(2, 3),
                query(3, 2),
                query(1, 4),
                query(1, 5),
                query(1, 5),
                query(1, 4),
                query(3, 2),
                query(2, 4),
                query(3, 2)), asList(0, 1, 1)
        );

        private final List<List<Integer>> queries;
        private final List<Integer> expectedOutput;

        Scenario(List<List<Integer>> queries, List<Integer> expectedOutput) {
            this.queries = queries;
            this.expectedOutput = expectedOutput;
        }
    }

}