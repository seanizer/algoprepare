package sean.crackingTheCodingInterview.ch2LinkedLists;

/*
Partition: Write code to partition a linked list around a value x, such that all nodes less than x come
before all nodes greater than or equal to x. If x is contained within the list, the values of x only need
to be after the elements less than x (see below). The partition element x can appear anywhere in the
"right partition"; it does not need to appear between the left and right partitions.
EXAMPLE
Input:
Output:
3 -> 5 -> 8 -> 5 -> 10 -> 2 -> 1 [partition= 5]
3 -> 1 -> 2 -> 10 -> 5 -> 5 -> 8
 */
public class Partition {
    static <T extends Comparable<T>> void partition(LinkedList<T> list, T partitionPoint) {
        LinkedList<T> clone = list.copy();
        LinkedList<T> lowPointer = list;
        LinkedList<T> highPointer = list.getNext();
        while (highPointer != null) {
            T value = highPointer.getValue();
            if (value.compareTo(partitionPoint) <= 0) {
                LinkedList<T> next = lowPointer.getNext();
                LinkedList<T> newNode = new LinkedList<>(value);
                lowPointer.setNext(newNode);
                lowPointer = newNode;
                newNode.setNext(next);
                LinkedList<T> hiNext = highPointer.getNext();
                if (hiNext != null) {
                    highPointer.setValue(next.getValue());
                    highPointer.setNext(hiNext.getNext());
                } else {
                    highPointer.setValue(null);
                    LinkedList<T> current = lowPointer;
                    while (current != null && current.getNext() != null) {
                        if (current.getNext().getValue() == null)
                            current.setNext(null);
                        current = current.getNext();
                    }
                }
            }
            highPointer = highPointer.getNext();
        }

    }
}
