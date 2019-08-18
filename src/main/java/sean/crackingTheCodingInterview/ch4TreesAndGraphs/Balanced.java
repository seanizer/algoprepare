package sean.crackingTheCodingInterview.ch4TreesAndGraphs;

import java.util.Optional;
import java.util.concurrent.atomic.AtomicBoolean;

public interface Balanced {

  static Balanced get() {
    return new Solution();
  }

  boolean isBalanced(AbstractBstNode<?, ?> node);

  class Solution implements Balanced {

    @Override
    public boolean isBalanced(AbstractBstNode<?, ?> node) {
      AtomicBoolean failed = new AtomicBoolean(false);
      node.inOrderTraversal((n) -> {
        if (!failed.get()) {
          Integer leftDepth = Optional.ofNullable(n.getLeft())
                                      .map(AbstractBstNode::depth)
                                      .orElse(0);
          Integer rightDepth = Optional.ofNullable(n.getRight())
                                       .map(AbstractBstNode::depth)
                                       .orElse(0);
          if (Math.abs(leftDepth - rightDepth) > 1) {
            failed.set(true);
          }
        }

      });
      return !failed.get();
    }
  }
}
