package sean.hackerrank.strings;

import static org.assertj.core.api.Assertions.assertThat;
import static sean.hackerrank.strings.SpecialPalindrome.substrCount;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import sean.util.FileHelper;

class SpecialPalindromeTest {


  @ParameterizedTest
  @EnumSource(Scenario.class)
  void specPal(Scenario scenario) {
    assertThat(substrCount(scenario.word.length(), scenario.word)).isEqualTo(
        scenario.expectedResult);
  }

  private enum Scenario {
    CASE1("asasd", 7),
    CASE2("abcbaba", 10),
    CASE3("aaaa", 10),
    BIG(FileHelper.readFileToString("specialPalindrome.txt"), 1730216);

    private final String word;
    private final int expectedResult;

    Scenario(String word, int expectedResult) {

      this.word = word;
      this.expectedResult = expectedResult;
    }
  }


}