package sean.hackerrank.strings;

import static org.assertj.core.api.Assertions.assertThat;
import static sean.hackerrank.strings.SherlockAnagrams.sherlockAndAnagrams;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

class SherlockAnagramsTest {

  @ParameterizedTest
  @EnumSource(Scenario.class)
  void testSherlock(Scenario scenario) {
    assertThat(sherlockAndAnagrams(scenario.word)).describedAs(scenario.word)
                                                  .isEqualTo(scenario.expectedResult);
  }

  private enum Scenario {
    EXAMPLE1("ifailuhkqq", 3),
    EXAMPLE2("kkkk", 10);
    private final String word;
    private final int expectedResult;

    Scenario(String word, int expectedResult) {
      this.word = word;
      this.expectedResult = expectedResult;
    }
  }

}