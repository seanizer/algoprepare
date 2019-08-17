package sean.hackerrank.strings;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static sean.hackerrank.strings.LoveLetterMistery.theLoveLetterMystery;

class LoveLetterMisteryTest {

    @Test
    void sampleInput() {
        assertThat(theLoveLetterMystery("abc")).isEqualTo(2);
        assertThat(theLoveLetterMystery("abcba")).isEqualTo(0);
        assertThat(theLoveLetterMystery("abcd")).isEqualTo(4);
        assertThat(theLoveLetterMystery("cba")).isEqualTo(2);
    }

}