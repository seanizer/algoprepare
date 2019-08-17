package sean.hackerrank.strings;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static sean.hackerrank.strings.Anagram.anagram;

class AnagramTest {

    @Test
    void aaabbb() {
        assertThat(anagram("aaabbb")).isEqualTo(3);
    }

    @Test
    void xaxbbbxx() {
        assertThat(anagram("xaxbbbxx")).isEqualTo(1);
    }


}