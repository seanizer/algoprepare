package sean.hackerrank.search;

import static org.assertj.core.api.Assertions.assertThat;
import static sean.hackerrank.search.TripleSum.triplets;
import static sean.util.ArrayHelper.arr;
import static sean.util.FileHelper.intArraysFromFile;

import org.junit.jupiter.api.Test;

class TripleSumTest {

  @Test
  void sampleInput0() {
    assertThat(
        triplets(
            arr(1, 3, 5),
            arr(2, 3),
            arr(1, 2, 3))).isEqualTo(8);
  }

  @Test
  void sampleInput1() {
    assertThat(triplets(
        arr(1, 4, 5),
        arr(2, 3, 3),
        arr(1, 2, 3))).isEqualTo(5);
  }

  @Test
  void sampleInput2() {
    assertThat(triplets(
        arr(1, 3, 5, 7),
        arr(5, 7, 9),
        arr(7, 9, 11, 13))).isEqualTo(12);
  }

  @Test
  void testCase8() {

    int[][] rows = intArraysFromFile("tripleSum1.txt");
    assertThat(triplets(
        rows[0],
        rows[1],
        rows[2])).isEqualTo(12603652660415L);

  }

  @Test
  void testCase4() {

    int[][] rows = intArraysFromFile("tripleSum2.txt");
    assertThat(triplets(
        rows[0],
        rows[1],
        rows[2])).isEqualTo(145333908482693L);

  }

}