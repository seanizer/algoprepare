package sean.crackingTheCodingInterview.ch2LinkedLists;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static sean.crackingTheCodingInterview.ch2LinkedLists.LinkedListHelper.toLinkedList;
import static sean.crackingTheCodingInterview.ch2LinkedLists.SumList.sum;

class SumListTest {

    @Test
    void summSummSumm() {
        assertThat(
                sum(
                        toLinkedList(1, 2, 3),
                        toLinkedList(4, 5, 6)
                )
        ).containsExactly(5, 7, 9);
    }

}