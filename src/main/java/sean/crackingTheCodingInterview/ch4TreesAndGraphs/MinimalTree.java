package sean.crackingTheCodingInterview.ch4TreesAndGraphs;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MinimalTree {

    static <T extends Comparable<? super T>> Optional<Node<T>> enTree(List<T> data) {
        Optional<Slice<T>> optionalSlice = Slice.get(data);
        if (optionalSlice.isPresent()) {
            Slice<T> slice = optionalSlice.get();
            Node<T> node = new Node<>(slice.midPoint);
            addList(slice.left, node);
            addList(slice.right, node);
            return Optional.of(node);
        } else return Optional.empty();
    }

    private static <T extends Comparable<? super T>> void addList(List<T> list, Node<T> node) {
        Slice.get(list).ifPresent(slice -> {
            node.addValue(slice.midPoint);
            addList(slice.left, node);
            addList(slice.right, node);
        });
    }


    static class Slice<T> {
        final List<T> left;
        final T midPoint;
        final List<T> right;

        Slice(List<T> input) {
            int midPointOffset = input.size() / 2;
            midPoint = input.get(midPointOffset);
            left = midPointOffset > 0 ? input.subList(0, midPointOffset) : Collections.emptyList();
            right = midPointOffset < input.size() - 1 ? input.subList(midPointOffset + 1, input.size()) : Collections.emptyList();
        }

        static <T> Optional<Slice<T>> get(List<T> input) {
            if (input.isEmpty()) return Optional.empty();
            else return Optional.of(new Slice<>(input));
        }
    }

    static class Node<T extends Comparable<? super T>> {
        final T value;
        Node<T> left;
        Node<T> right;

        Node(T value) {
            this.value = value;
        }

        int height() {
            return 1 +
                    Stream.of(left, right)
                          .filter(Objects::nonNull)
                          .map(Node::height)
                          .max(Comparator.naturalOrder())
                          .orElse(0);
        }

        void addValue(T value) {
            int comparison = value.compareTo(this.value);
            if (comparison < 0) addLeft(value);
            if (comparison > 0) addRight(value);
        }

        private void addRight(T value) {
            if (right == null) right = new Node<>(value);
            else right.addValue(value);
        }

        private void addLeft(T value) {
            if (left == null) left = new Node<>(value);
            else left.addValue(value);
        }

        @Override
        public String toString() {
            return Stream.of(left, value, right)
                         .filter(Objects::nonNull)
                         .map(Objects::toString)
                         .collect(Collectors.joining(",", "[", "]"));

            /*
            [[[[1],2],3,[4]]5,[[6],7,[8]]]

                             5
                         3       7
                      2    4   6   8
                   1


             */
        }

    }
}
