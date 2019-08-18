package sean.crackingTheCodingInterview.ch2LinkedLists;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;
import static org.assertj.core.api.Assertions.assertThat;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import java.util.function.Consumer;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

class RemoveDuplicatesTest {


  @StrategyTest
  void palindrome(Strategy strategy) {
    LinkedList<Integer> list = LinkedListHelper.toLinkedList(1, 2, 3, 4, 5, 6, 5, 4, 3, 2, 1);
    strategy.accept(list);
    assertThat(list).containsExactly(1, 2, 3, 4, 5, 6);
  }

  @StrategyTest
  void blockWise(Strategy strategy) {
    LinkedList<Integer> list = LinkedListHelper.toLinkedList(1, 1, 1, 1, 2, 2, 2, 2, 3, 3, 3, 3, 4,
                                                             4, 4, 4, 5, 5, 5, 5);
    strategy.accept(list);
    assertThat(list).containsExactly(1, 2, 3, 4, 5);
  }

  private enum Strategy implements Consumer<LinkedList<?>> {
    BUFFER {
      @Override
      public void accept(LinkedList<?> objects) {
        RemoveDuplicates.removeDuplicates(objects);
      }
    }, NO_BUFFER {
      @Override
      public void accept(LinkedList<?> objects) {
        RemoveDuplicates.removeDupesWithoutBuffer(objects);
      }
    }
  }

  @Retention(RUNTIME)
  @Target(METHOD)
  @ParameterizedTest
  @EnumSource(Strategy.class)
  @interface StrategyTest {

  }

}