package sean.hackerrank.search;

import org.junit.jupiter.api.Test;
import sean.util.ArrayHelper;

import static org.assertj.core.api.Assertions.assertThat;
import static sean.hackerrank.search.Pairs.pairs;

class PairsTest {

    @Test
    void sampleInput() {
        assertThat(pairs(2, ArrayHelper.arr(1, 5, 3, 4, 2))).isEqualTo(3);
    }

}