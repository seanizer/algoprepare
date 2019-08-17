package sean.crackingTheCodingInterview.ch2LinkedLists;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static sean.crackingTheCodingInterview.ch2LinkedLists.Partition.partition;

class PartitionTest {

    @Test
    void testPartition() {
        LinkedList<Integer> list = LinkedListHelper.toLinkedList(2, 10, 2, 10, 2, 10, 2, 10, 5);
        partition(list, 5);
        assertThat(list).containsExactly(2, 2, 2, 2, 5, 10, 10, 10, 10);
    }

}