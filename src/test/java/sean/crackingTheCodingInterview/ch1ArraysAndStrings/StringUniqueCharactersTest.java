package sean.crackingTheCodingInterview.ch1ArraysAndStrings;

import static org.assertj.core.api.Assertions.assertThat;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.function.Supplier;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

class StringUniqueCharactersTest {

  private static void assertStringUniqueChars(Strategy strategy, String testString,
                                              boolean expectation) {
    assertThat(strategy.get().hasUniqueChars(testString)).describedAs("'%s'.hasUniqueChars()",
                                                                      testString)
                                                         .isEqualTo(expectation);
  }

  @StrategyTest
  void empty(Strategy strategy) {
    assertStringUniqueChars(strategy, "", true);
  }

  @StrategyTest
  void minimal(Strategy strategy) {
    assertStringUniqueChars(strategy, "a", true);
  }

  @StrategyTest
  void minimalRepetition(Strategy strategy) {
    assertStringUniqueChars(strategy, "aa", false);
  }

  @StrategyTest
  void nonAscii(Strategy strategy) {
    assertStringUniqueChars(strategy, "⼣⼣⼣", false);
  }

  private enum Strategy implements Supplier<StringUniqueCharacters.UniqueCharChecker> {
    HASHSET {
      @Override
      public StringUniqueCharacters.UniqueCharChecker get() {
        return new StringUniqueCharacters.HashSetUniqueCharChecker();
      }
    }, LONG_ARRAY {
      @Override
      public StringUniqueCharacters.UniqueCharChecker get() {
        return new StringUniqueCharacters.LongArrayUniqueCharChecker();
      }
    }
  }

  @Target(ElementType.METHOD)
  @Retention(RetentionPolicy.RUNTIME)
  @ParameterizedTest
  @EnumSource(Strategy.class)
  @interface StrategyTest {

  }

}