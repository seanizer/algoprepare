package sean.crackingTheCodingInterview.ch1ArraysAndStrings;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.function.Supplier;

import static org.assertj.core.api.Assertions.assertThat;

class AnagramCheckerTest {

    void assertAnagram(Strategy strategy, String left, String right, boolean expectedResult) {
        assertThat(strategy.get()
                           .isAnagram(left, right)).describedAs("AnagramChecker(%s).isAnagram(%s, %s)", strategy, left, right)
                                                   .isEqualTo(expectedResult);
    }

    @StrategyTest
    void empty(Strategy strategy) {
        assertAnagram(strategy, "", "", true);
        assertAnagram(strategy, "abc", "", false);
        assertAnagram(strategy, "", "xyz", false);
    }

    @StrategyTest
    void differentLength(Strategy strategy) {
        assertAnagram(strategy, "abc", "abcabcabc", false);
        assertAnagram(strategy, "abcabcabc", "abc", false);
    }

    @StrategyTest
    void validAnagram(Strategy strategy) {
        assertAnagram(strategy, "aaabbbccc", "abcabcabc", true);
        assertAnagram(strategy, "scarier", "carries", true);

    }

    private enum Strategy implements Supplier<AnagramChecker> {
        SORTING {
            @Override
            public AnagramChecker get() {
                return new AnagramChecker.SortingAnagramChecker();
            }
        }, COUNTING {
            @Override
            public AnagramChecker get() {
                return new AnagramChecker.CountingAnagramChecker();
            }
        }
    }

    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.METHOD)
    @ParameterizedTest
    @EnumSource(Strategy.class)
    @interface StrategyTest {
    }


}