package sean.crackingTheCodingInterview.ch1ArraysAndStrings;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static sean.crackingTheCodingInterview.ch1ArraysAndStrings.StringCompress.compress;


class StringCompressTest {

    @Test
    void tooShort() {
        assertThat(compress("")).isEqualTo("");
        assertThat(compress("x")).isEqualTo("x");
    }

    @Test
    void tooComplex() {
        assertThat(compress("mxyzptlk")).isEqualTo("mxyzptlk");

    }

    @Test
    void justRight() {
        assertThat(compress("aaaaarrrdvaaaaarrkkk")).isEqualTo("a5r3d1v1a5r2k3");
    }

}