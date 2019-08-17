package sean.hackerrank.search;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static sean.hackerrank.search.IceCreamParlor.returnWhatFlavors;

class IceCreamParlorTest {

    static int[] arr(int... values) {
        return values;
    }

    @Test
    void sampleInput1() {
        assertThat(returnWhatFlavors(arr(1, 4, 5, 3, 2), 4)).containsExactly(1, 4);
    }

    @Test
    void sampleInput2() {
        assertThat(returnWhatFlavors(arr(2, 2, 4, 3), 4)).containsExactly(1, 2);

    }

}