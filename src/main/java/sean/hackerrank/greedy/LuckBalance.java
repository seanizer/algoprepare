package sean.hackerrank.greedy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.concurrent.atomic.AtomicInteger;

// https://www.hackerrank.com/challenges/luck-balance
public class LuckBalance {

  static int luckBalance(int k, int[][] c) {
    AtomicInteger ai = new AtomicInteger(k);
    Comparator<Contest> comparator = Comparator.comparing(Contest::isImportant)
                                               .thenComparingInt(Contest::getLuck).reversed();
    return Arrays.stream(c)
                 .map(Contest::forArray)
                 .sorted(comparator)
                 .mapToInt(co -> !co.isImportant() || ai.getAndDecrement() > 0 ?
                                 co.getLuck() : -co.getLuck())
                 .sum();
  }

  static class Contest {

    final int luck;
    final boolean important;

    public int getLuck() {
      return luck;
    }

    public boolean isImportant() {
      return important;
    }

    Contest(int luck, boolean important) {
      this.luck = luck;
      this.important = important;
    }

    static Contest forArray(int[] array) {
      return new Contest(array[0], array[1] != 0);
    }

  }
}
