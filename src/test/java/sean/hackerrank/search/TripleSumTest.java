package sean.hackerrank.search;

import static org.assertj.core.api.Assertions.assertThat;
import static sean.hackerrank.search.TripleSum.triplets;
import static sean.util.ArrayHelper.arr;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

class TripleSumTest {

  static int[][] fromFile(String fileName) {

    try {
      URL url = TripleSum.class.getResource("/" + fileName);
      File f = new File(url.toURI());
      return Files.readAllLines(f.toPath())
                  .stream()
                  .map(s -> Arrays.stream(s.split("\\s+")).mapToInt(Integer::parseInt).toArray())
                  .toArray(int[][]::new);

    } catch (URISyntaxException | IOException e) {
      throw new IllegalStateException(e);
    }
  }

  @Test
  void sampleInput0() {
    assertThat(triplets(
        arr(1, 3, 5),
        arr(2, 3),
        arr(1, 2, 3)
                       )).isEqualTo(8);
  }

  @Test
  void sampleInput1() {
    assertThat(triplets(
        arr(1, 4, 5),
        arr(2, 3, 3),
        arr(1, 2, 3)
                       )).isEqualTo(5);
  }

  @Test
  void sampleInput2() {
    assertThat(triplets(
        arr(1, 3, 5, 7),
        arr(5, 7, 9),
        arr(7, 9, 11, 13)
                       )).isEqualTo(12);
  }

  @Test
  void testCase8() {
    int[][] rows = fromFile("tripleSum1.txt");
    assertThat(triplets(
        rows[0],
        rows[1],
        rows[2]
                       )).isEqualTo(12603652660415L);

  }

  @Test
  void testCase4() {
    int[][] rows = fromFile("tripleSum2.txt");
    assertThat(triplets(
        rows[0],
        rows[1],
        rows[2]
                       )).isEqualTo(145333908482693L);

  }

}