package sean.crackingTheCodingInterview.ch3StacksAndQueues;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.function.BiConsumer;
import org.junit.jupiter.api.Test;

class MultiStackTest {


  void doWithIndex(MultiStack multiStack, int max, BiConsumer<MultiStack, Integer> what) {
    for (int i = 0; i < max; i++) {
      what.accept(multiStack, i);
    }
  }

  void doWithLoweringIndex(MultiStack multiStack, int max, BiConsumer<MultiStack, Integer> what) {
    for (int i = max - 1; i >= 0; i--) {
      what.accept(multiStack, i);
    }
  }

  @Test
  void pushPopAndAll() {
    int partitions = 3;
    MultiStack multiStack = MultiStack.getArrayBasedMultiStack(partitions);
    int cardinality = 5;

    doWithIndex(multiStack, partitions, (m, offset) ->
        doWithIndex(multiStack, cardinality, (m2, value) -> m2.push(value, offset)));
    doWithIndex(multiStack, partitions, (m, offset) ->
        doWithLoweringIndex(multiStack, cardinality,
                            (m2, value) -> assertThat(m2.pop(offset)).hasValue(value)));
    doWithIndex(multiStack, partitions, (m, offset) -> assertThat(m.pop(offset)).isEmpty());
  }

}