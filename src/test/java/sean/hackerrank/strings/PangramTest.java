package sean.hackerrank.strings;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static sean.hackerrank.strings.Pangram.*;

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