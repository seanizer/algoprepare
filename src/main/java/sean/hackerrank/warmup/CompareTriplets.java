package sean.hackerrank.warmup;

import static java.util.Arrays.asList;

import java.util.List;

// https://www.hackerrank.com/challenges/compare-the-triplets
public class CompareTriplets {

  static List<Integer> compareTriplets(List<Integer> a, List<Integer> b) {

    int ascore = 0;
    int bscore = 0;

    for (int i = 0; i < 3; i++) {

      int x = a.get(i);
      int y = b.get(i);

      if (x < y) {
        bscore++;
      } else if (x > y) {
        ascore++;
      }
    }

    return asList(ascore, bscore);

  }
}
