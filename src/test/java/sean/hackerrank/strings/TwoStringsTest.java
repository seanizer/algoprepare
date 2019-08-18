package sean.hackerrank.strings;

import static org.assertj.core.api.Assertions.assertThat;
import static sean.hackerrank.strings.TwoStrings.NO;
import static sean.hackerrank.strings.TwoStrings.YES;
import static sean.hackerrank.strings.TwoStrings.twoStrings;

import org.junit.jupiter.api.Test;

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