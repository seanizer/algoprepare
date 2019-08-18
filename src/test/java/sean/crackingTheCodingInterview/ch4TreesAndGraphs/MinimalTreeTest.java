package sean.crackingTheCodingInterview.ch4TreesAndGraphs;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

class MinimalTreeTest {

  static IntStream range() {
    return IntStream.range(0, 20);
  }


  @MethodSource("range")
  @ParameterizedTest
  void entreeList(int length) {
    List<Integer> list = IntStream.range(0, length).boxed().collect(Collectors.toList());
    Optional<MinimalTree.Node<Integer>> optionalNode = MinimalTree.enTree(list);
    if (length == 0) {
      assertThat(optionalNode).isEmpty();
    } else {
      assertThat(optionalNode).isNotEmpty();
      MinimalTree.Node<Integer> node = optionalNode.get();
      assertThat(node.height()).isEqualTo((int) (Math.log(length) / Math.log(2)) + 1);
    }
  }

}