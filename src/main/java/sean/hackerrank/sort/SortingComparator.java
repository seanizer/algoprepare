package sean.hackerrank.sort;

import java.util.Comparator;

public class SortingComparator {

  static class Player {

    String name;
    int score;

    Player(String name, int score) {
      this.name = name;
      this.score = score;
    }

    @Override
    public String toString() {
      return String.format("%s %d", name, score);
    }
  }

  static class Checker implements Comparator<Player> {

    public int compare(Player a, Player b) {
      int result = Integer.compare(b.score, a.score);
      if (result == 0) {
        return a.name.compareTo(b.name);
      } else {
        return result;
      }
    }
  }


}
