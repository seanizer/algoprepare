package sean.hackerrank.strings;

import static org.assertj.core.api.Assertions.assertThat;
import static sean.hackerrank.strings.AnagramMaker.makeAnagram;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

class AnagramMakerTest {

  @ParameterizedTest
  @EnumSource(Scenario.class)
  void earMagArkMan(Scenario scenario) {
    assertThat(makeAnagram(scenario.left, scenario.right)).isEqualTo(scenario.expectedAnagrams);
  }

  private enum Scenario {
    EXAMPLE("cde", "abc", 4);

    private final String left;
    private final String right;
    private final int expectedAnagrams;

    Scenario(String left, String right, int expectedAnagrams) {
      this.left = left;
      this.right = right;
      this.expectedAnagrams = expectedAnagrams;
    }
  }


}