package sean.crackingTheCodingInterview.ch1ArraysAndStrings;


import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;
import static org.assertj.core.api.Assertions.assertThat;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import java.util.function.Supplier;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

class SpaceReplacerTest {

  @StrategyTest
  void empty(Strategy strategy) {
    strategyAssert(strategy, "", "");
  }

  @StrategyTest
  void onlySpace(Strategy strategy) {
    strategyAssert(strategy, " ", "%20");
  }

  @StrategyTest
  void noSpace(Strategy strategy) {
    strategyAssert(strategy, "abcdef", "abcdef");
  }

  @StrategyTest
  void sentence(Strategy strategy) {
    strategyAssert(strategy, "I am the god of hellfire", "I%20am%20the%20god%20of%20hellfire");
  }

  private void strategyAssert(Strategy strategy, String input, String expectedResult) {
    assertThat(strategy.get().replaceSpaces(input)).describedAs("$s.replaceSpaces('%s')", strategy)
                                                   .isEqualTo(expectedResult);
  }

  private enum Strategy implements Supplier<SpaceReplacer> {
    STRING_BUILDER {
      @Override
      public SpaceReplacer get() {
        return new SpaceReplacer.StringBuilderSpaceReplacer();
      }
    }
  }

  @Retention(RUNTIME)
  @Target(METHOD)
  @ParameterizedTest
  @EnumSource(Strategy.class)
  @interface StrategyTest {

  }


}