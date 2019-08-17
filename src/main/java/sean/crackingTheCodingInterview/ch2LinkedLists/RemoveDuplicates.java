package sean.crackingTheCodingInterview.ch2LinkedLists;

import java.util.HashSet;
import java.util.Set;

public class RemoveDuplicates {

    static <T> void removeDuplicates(LinkedList<T> linkedList) {
        Set<T> existing = new HashSet<>();
        LinkedList<T> lastUnique = linkedList;
        existing.add(lastUnique.getValue());
        LinkedList<T> temp = lastUnique.getNext();
        while (temp != null) {
            T value = temp.getValue();
            if (existing.contains(value)) {
                lastUnique.dropNext();
            } else {
                lastUnique = temp;
                existing.add(value);
            }
            temp = lastUnique.getNext();
        }
    }

    static <T> void removeDupesWithoutBuffer(LinkedList<T> linkedList) {
        LinkedList<T> outer = linkedList;
        LinkedList<T> last = outer;
        while (outer != null) {
            LinkedList<T> inner = last.getNext();
            while (inner != null) {
                if (outer.getValue().equals(inner.getValue())) {
                    last.dropNext();
                } else {
                    last = inner;
                }
                inner = last.getNext();
            }
            outer = outer.getNext();
            last = outer;
        }
    }

}
