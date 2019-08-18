package sean.crackingTheCodingInterview.ch1ArraysAndStrings;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class StringRotationTest {

  @Test
  void tooSmall() {
    assertRotated("", "", true);
    assertRotated("a", "a", true);
  }

  @Test
  void differentLength() {
    assertRotated("", "abc", false);
    assertRotated("abcdef", "abc", false);
  }

  @Test
  void rotated() {
    assertRotated("pigdog", "dogpig", true);
  }

  @Test
  void notRotated() {
    assertRotated("pigdogpig", "dogpigdog", false);
  }

  private void assertRotated(String left, String right, boolean expected) {
    assertThat(StringRotation.isRotated(left, right)).describedAs("isRotated(%s, %s)", left, right)
                                                     .isEqualTo(expected);
  }

}