package sean.hackerrank.recursion;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static sean.hackerrank.recursion.CrosswordPuzzle.crosswordPuzzle;
import static sean.util.ArrayHelper.arr;

@Disabled("Not implemented yet")
class CrosswordPuzzleTest {

    @Test
    void sampleInput0() {
        assertThat(
                crosswordPuzzle(
                        arr(
                                "+-++++++++",
                                "+-++++++++",
                                "+-++++++++",
                                "+-----++++",
                                "+-+++-++++",
                                "+-+++-++++",
                                "+++++-++++",
                                "++------++",
                                "+++++-++++",
                                "+++++-++++"
                        ), "LONDON;DELHI;ICELAND;ANKARA")
        ).containsExactly(
                "+L++++++++",
                "+O++++++++",
                "+N++++++++",
                "+DELHI++++",
                "+O+++C++++",
                "+N+++E++++",
                "+++++L++++",
                "++ANKARA++",
                "+++++N++++",
                "+++++D++++"
        );
    }


}