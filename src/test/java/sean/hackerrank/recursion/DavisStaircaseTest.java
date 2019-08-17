package sean.hackerrank.recursion;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static sean.hackerrank.recursion.DavisStaircase.stepPerms;

class DavisStaircaseTest {

    @Test
    void sampleInput1() {
        assertThat(stepPerms(1)).isEqualTo(1);
    }

    @Test
    void sampleInput2() {
        assertThat(stepPerms(3)).isEqualTo(4);
    }

    @Test
    void sampleInput3() {
        assertThat(stepPerms(7)).isEqualTo(44);
    }


}