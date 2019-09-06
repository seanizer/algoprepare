package sean.hackerrank.sort;

import static java.util.stream.Collectors.toList;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;
import sean.hackerrank.sort.SortingComparator.Checker;
import sean.hackerrank.sort.SortingComparator.Player;

class SortingComparatorTest {

  static Player player(String name, int score) {
    return new Player(name, score);
  }

  static List<String> sortAndPrintPlayers(Player... players) {
    return Arrays.stream(players)
                 .sorted(new Checker())
                 .map(Object::toString)
                 .collect(toList());
  }

  @Test
  void sampleInput() {
    assertThat(sortAndPrintPlayers(
        player("amy", 100),
        player("david", 100),
        player("heraldo", 50),
        player("aakansha", 75),
        player("aleksa", 150))
              ).containsExactly("aleksa 150",
                                "amy 100",
                                "david 100",
                                "aakansha 75",
                                "heraldo 50");
  }

}