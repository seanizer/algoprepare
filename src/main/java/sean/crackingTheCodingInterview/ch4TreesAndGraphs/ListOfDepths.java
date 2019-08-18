package sean.crackingTheCodingInterview.ch4TreesAndGraphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public interface ListOfDepths<T extends Comparable<? super T>> {

  static <T extends Comparable<? super T>> ListOfDepths<T> get() {
    return new Solution<>();
  }

  List<List<Bst<T>>> listOfDepth(Bst<T> node);

  class Solution<T extends Comparable<? super T>> implements ListOfDepths<T> {

    @Override
    public List<List<Bst<T>>> listOfDepth(Bst<T> node) {

      List<List<Bst<T>>> result = new ArrayList<>(node.depth());
      node.depthFirstTraversal((n) -> {
        int depth = n.depth();
        while (result.size() < depth) {
          result.add(new LinkedList<>());
        }
        result.get(depth - 1).add(n);
      });
      return result;
    }
  }
}
