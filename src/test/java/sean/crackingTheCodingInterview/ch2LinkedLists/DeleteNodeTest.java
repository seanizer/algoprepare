package sean.crackingTheCodingInterview.ch2LinkedLists;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class DeleteNodeTest {

    @Test
    void deleteBeginning() {
        LinkedList<Integer> list = LinkedListHelper.toLinkedList(1, 2, 3, 4, 5);
        DeleteNode.deleteNode(list);
        assertThat(list).containsExactly(2, 3, 4, 5);
    }

    @Test
    void deleteMiddle() {
        LinkedList<Integer> list = LinkedListHelper.toLinkedList(1, 2, 3, 4, 5);
        DeleteNode.deleteNode(list.getNext().getNext());
        assertThat(list).containsExactly(1, 2, 4, 5);
    }

    @Test
    void deleteEnd() {
        LinkedList<Integer> list = LinkedListHelper.toLinkedList(1, 2, 3, 4, 5);
        assertThatThrownBy(() -> DeleteNode.deleteNode(list.getNext()
                                                           .getNext()
                                                           .getNext()
                                                           .getNext())).isInstanceOf(UnsupportedOperationException.class);
    }

}