package sean.crackingTheCodingInterview.ch4TreesAndGraphs;

import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

class ListOfDepthsTest {

    @Test
    void skewed() {
        Bst<Integer> bst = Bst.createBst(0);
        IntStream.range(1, 10).forEach(bst::addValue);
        List<List<Bst<Integer>>> depthLists = ListOfDepths.<Integer>get().listOfDepth(bst);
        assertThat(depthLists).hasSize(10).extracting(List::size).containsExactlyElementsOf(Collections.nCopies(10, 1));
        System.out.println(depthLists);
    }

}