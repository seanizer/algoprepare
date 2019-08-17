package sean.hackerrank.strings;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static sean.hackerrank.strings.Pangram.NO_PANGRAM;
import static sean.hackerrank.strings.Pangram.PANGRAM;
import static sean.hackerrank.strings.Pangram.pangrams;

class PangramTest {

    @Test
    void valid() {
        assertThat(pangrams("We promptly judged antique ivory buckles for the next prize")).isEqualTo(PANGRAM);
    }

    @Test
    void invalid() {
        assertThat(pangrams("We promptly judged antique ivory buckles for the prize")).isEqualTo(NO_PANGRAM);
    }

}