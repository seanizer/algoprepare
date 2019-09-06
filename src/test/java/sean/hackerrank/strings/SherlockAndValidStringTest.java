package sean.hackerrank.strings;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import sean.util.FileHelper;

class SherlockAndValidStringTest {

  static String loadFromFile(String fileName) {
    return FileHelper.readFileToString(fileName).trim();
  }

  @ParameterizedTest
  @EnumSource(Scenario.class)
  void sherlockValidator(Scenario scenario) {

    String answer = scenario.valid ? "YES" : "NO";
    assertThat(SherlockAndValidString.isValid(scenario.word))
        .describedAs("Word: %s, expected answer: %s", scenario.word, answer)
        .isEqualTo(answer);
  }

  private enum Scenario {
    EXAMPLE1("aabbcd", false),
    EXAMPLE2("aabbccddeefghi", false),
    EXAMPLE3("abcdefghhgfedecba", true),
    TESTCASE(loadFromFile("sherlockValidString1.txt"), true);

    private final String word;
    private final boolean valid;

    Scenario(String word, boolean valid) {

      this.word = word;
      this.valid = valid;
    }
  }

}