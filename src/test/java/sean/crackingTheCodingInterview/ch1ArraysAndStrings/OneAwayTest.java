package sean.crackingTheCodingInterview.ch1ArraysAndStrings;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;
import static org.assertj.core.api.Assertions.assertThat;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

class OneAwayTest {

  private OneAway.BasicOneAway checker = new OneAway.BasicOneAway();

  @SafeVarargs
  static <K, V> Map<K, V> maps(Map<K, V>... maps) {
    Map<K, V> map = new HashMap<>(maps.length);
    Arrays.stream(maps).forEach(map::putAll);
    return Collections.unmodifiableMap(map);
  }

  static <K, V> Map<K, V> map(K key, V value) {
    return Collections.singletonMap(key, value);
  }

  @ScenarioTest
  void oneAway(Scenario scenario) {
    scenario.wordPairs.forEach((key, value) ->
                                   assertThat(checker.oneAway(key, value)).describedAs(
                                       "oneAway('%s', '%s')", key, value)
                                                                          .isEqualTo(
                                                                              scenario.expectedResult));
  }

  private enum Scenario {
    ADD(maps(map("aid", "aids")), true),
    REMOVE(maps(map("star", "tar")), true),
    SWAP(maps(map("page", "rage")), true),
    EQUAL(map("frog", "frog"), true),
    INVALID(maps(map("", "abc"), map("a", "abc"), map("abcd", "abdc")), false);

    private final Map<String, String> wordPairs;
    private final boolean expectedResult;

    Scenario(Map<String, String> wordPairs, boolean expectedResult) {

      this.wordPairs = wordPairs;
      this.expectedResult = expectedResult;
    }
  }

  @Retention(RUNTIME)
  @Target(METHOD)
  @ParameterizedTest
  @EnumSource(Scenario.class)
  @interface ScenarioTest {

  }


}