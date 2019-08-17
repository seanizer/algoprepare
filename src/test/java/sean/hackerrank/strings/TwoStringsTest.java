package sean.hackerrank.strings;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static sean.hackerrank.strings.TwoStrings.*;

class TwoStringsTest {

    @Test
    void sampleInput1() {
        assertThat(twoStrings("hello", "world")).isEqualTo(YES);
    }

    @Test
    void sampleInput2() {
        assertThat(twoStrings("hi", "world")).isEqualTo(NO);
    }


}