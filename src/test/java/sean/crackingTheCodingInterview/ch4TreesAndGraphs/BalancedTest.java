package sean.crackingTheCodingInterview.ch4TreesAndGraphs;

import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

class BalancedTest {

    @Test
    void skewed() {
        Bst<Integer> bst = Bst.createBst(0);
        IntStream.range(1, 10).forEach(bst::addValue);
        assertThat(Balanced.get().isBalanced(bst)).describedAs("%s.isBalanced()", bst).isFalse();
    }

    @Test
    void even() {
        Bst<Integer> bst = Bst.createBst(64);
        IntStream.of(32, 128, 16, 48, 72, 96, 144).forEach(bst::addValue);
        assertThat(Balanced.get().isBalanced(bst)).describedAs("%s.isBalanced()", bst).isTrue();
    }

}