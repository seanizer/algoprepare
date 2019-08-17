package sean.crackingTheCodingInterview.ch4TreesAndGraphs;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.Objects;
import java.util.Optional;
import java.util.Queue;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

abstract class AbstractBinaryTreeNode<T, N extends AbstractBinaryTreeNode<T, N>> {
    private final T value;
    protected N left;
    protected N right;

    protected AbstractBinaryTreeNode(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    public N getLeft() {
        return left;
    }

    public N getRight() {
        return right;
    }

    protected abstract N newNode(T value);

    protected N thisNode() {
        @SuppressWarnings("unchecked") N n = (N) this;
        return n;
    }

    public void preOrderTraversal(Consumer<N> consumer) {
        if (left != null) left.preOrderTraversal(consumer);
        if (right != null) right.preOrderTraversal(consumer);
        consumer.accept(thisNode());
    }

    public void postOrderTraversal(Consumer<N> consumer) {
        consumer.accept(thisNode());
        if (left != null) left.postOrderTraversal(consumer);
        if (right != null) right.postOrderTraversal(consumer);
    }

    public void inOrderTraversal(Consumer<N> consumer) {
        if (left != null) left.inOrderTraversal(consumer);
        consumer.accept(thisNode());
        if (right != null) right.inOrderTraversal(consumer);
    }

    public void depthFirstTraversal(Consumer<N> consumer) {
        postOrderTraversal(consumer);
    }

    public int depth() {
        return 1 + Stream.of(left, right)
                         .filter(Objects::nonNull)
                         .map(AbstractBinaryTreeNode::depth)
                         .max(Comparator.naturalOrder())
                         .orElse(0);
    }

    public void breadthFirstTraversal(Consumer<N> consumer) {
        N currentNode = thisNode();
        Queue<N> queue = new LinkedList<>();
        while (currentNode != null) {
            consumer.accept(currentNode);
            Optional.ofNullable(currentNode.getLeft()).ifPresent(queue::offer);
            Optional.ofNullable(currentNode.getRight()).ifPresent(queue::offer);
            currentNode = queue.poll();
        }
    }

    @Override
    public String toString() {
        return Stream.of(left, value, right)
                     .filter(Objects::nonNull)
                     .map(Object::toString)
                     .collect(Collectors.joining(", ", "[", "]"));
    }
}
