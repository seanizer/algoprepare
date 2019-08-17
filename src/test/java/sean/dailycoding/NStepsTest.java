package sean.dailycoding;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;

import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;


class NStepsTest {

    NSteps nSteps;

    @BeforeEach
    void setUp() {
        nSteps = NSteps.get();
    }

    @Test
    void length4AndStepsSmallerThan3() {
        assertThat(nSteps.possibleStepPatternsForNLt3(4)).containsOnly(
                asList(1, 1, 1, 1),
                asList(2, 1, 1),
                asList(1, 2, 1),
                asList(1, 1, 2),
                asList(2, 2)
        );
    }

    @Test
    void length10AndDisjunctAlphabet() {
        assertThat(nSteps.possibleStepPatterns(6, new HashSet<>(Arrays.asList(1, 2, 5)))).containsOnly(
                asList(1, 1, 1, 1, 1, 1),
                asList(2, 1, 1, 1, 1),
                asList(1, 2, 1, 1, 1),
                asList(1, 1, 2, 1, 1),
                asList(1, 1, 1, 2, 1),
                asList(1, 1, 1, 1, 2),
                asList(2, 2, 1, 1),
                asList(2, 1, 2, 1),
                asList(2, 1, 1, 2),
                asList(1, 2, 2, 1),
                asList(1, 1, 2, 2),
                asList(1, 2, 1, 2),
                asList(2, 2, 2),
                asList(1, 5),
                asList(5, 1)
        );
    }

}