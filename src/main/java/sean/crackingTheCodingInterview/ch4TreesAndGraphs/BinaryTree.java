package sean.crackingTheCodingInterview.ch4TreesAndGraphs;

import java.util.Objects;
import java.util.stream.Stream;

public class BinaryTree<T> extends AbstractBinaryTreeNode<T, BinaryTree<T>> {

  public BinaryTree(T value) {
    super(value);
  }

  @Override
  protected BinaryTree<T> newNode(T value) {
    return new BinaryTree<>(value);
  }

  public void addLeft(T value) {
    this.left = newNode(value);
  }

  public void addRight(T value) {
    this.right = newNode(value);
  }

  public Stream<BinaryTree<T>> children() {
    return Stream.of(left, right).filter(Objects::nonNull);
  }
}
