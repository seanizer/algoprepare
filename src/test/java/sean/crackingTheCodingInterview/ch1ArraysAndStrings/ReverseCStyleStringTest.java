package sean.crackingTheCodingInterview.ch1ArraysAndStrings;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class ReverseCStyleStringTest {

    @StrategyTest
    void empty(Strategy strategy) {
        assertReverse(strategy, "", "");
    }

    @StrategyTest
    void singleChar(Strategy strategy) {
        assertReverse(strategy, "a", "a");
    }

    @StrategyTest
    void abc(Strategy strategy) {
        assertReverse(strategy, "abc", "cba");
    }

    @StrategyTest
    void palindrome(Strategy strategy) {
        assertReverse(strategy, "aBcDeFgHiJkLmNoPqRsTuVwXyZ", "ZyXwVuTsRqPoNmLkJiHgFeDcBa");
    }

    private void assertReverse(Strategy strategy, String input, String expectedOutput) {
        char[] inputArray = ReverseCStyleString.toCStyleString(input);
        char[] outputArray = ReverseCStyleString.toCStyleString(expectedOutput);
        char[] inputCopy = Arrays.copyOf(inputArray, inputArray.length);
        assertThat(strategy.reverse(inputArray)).describedAs("%s.reverse(%s)", strategy, Arrays.toString(inputCopy))
                                                .containsExactly(outputArray);
    }

    enum Strategy {
        INPLACE {
            @Override
            char[] reverse(char[] input) {
                return ReverseCStyleString.reverseCStyleStringInPlace(input);
            }
        }, COPY {
            @Override
            char[] reverse(char[] input) {
                return ReverseCStyleString.reverseCStyleStringCopy(input);
            }
        };

        abstract char[] reverse(char[] input);
    }

    @Target(ElementType.METHOD)
    @Retention(RetentionPolicy.RUNTIME)
    @ParameterizedTest
    @EnumSource(Strategy.class)
    @interface StrategyTest {
    }

}