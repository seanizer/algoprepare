package sean.crackingTheCodingInterview.ch2LinkedLists;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static sean.crackingTheCodingInterview.ch2LinkedLists.KthToLast.kthFromLast;
import static sean.crackingTheCodingInterview.ch2LinkedLists.LinkedListHelper.toLinkedList;

class KthToLastTest {

    @Test
    void tiny() {
        assertThat(kthFromLast(toLinkedList(1), 5)).isEmpty();
        assertThat(kthFromLast(toLinkedList(1), 0)).isNotEmpty().contains(1);
    }

    @Test
    void medium() {
        assertThat(kthFromLast(toLinkedList(1, 2, 3, 4), 5)).isEmpty();
        assertThat(kthFromLast(toLinkedList(1, 2, 3, 4), 2)).isNotEmpty().contains(2);
    }

    @Test
    void large() {
        assertThat(kthFromLast(toLinkedList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14), 25)).isEmpty();
        assertThat(kthFromLast(toLinkedList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14), 10)).isNotEmpty()
                                                                                                .contains(4);
    }


}