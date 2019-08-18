package sean.hackerrank.arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static sean.hackerrank.arrays.ArrayQuery.arrayManipulation;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

@Disabled("large queries not working yet")
class ArrayQueryTest {

  static int[][] arr(int[]... queries) {
    return queries;
  }

  static int[] query(int start, int end, int delta) {
    return new int[]{start, end, delta};
  }

  static int[][] fromFile(String fileName) {
    try {
      List<String> lines = Files.readAllLines(Paths.get("src/test/resources", fileName));
      return lines.stream()
                  .skip(1)
                  .filter(line -> !line.trim().isEmpty())
                  .map(line -> line.trim().split("\\s+"))
                  .map(arr -> Arrays.stream(arr).mapToInt(Integer::parseInt).toArray())
                  .toArray(int[][]::new);
    } catch (IOException e) {
      throw new IllegalStateException(e);
    }
  }

  @ParameterizedTest
  @EnumSource(Scenario.class)
  void query(Scenario scenario) {
    int arrLength = scenario.arrLength;
    long expectedMax = scenario.expectedMax;
    int[][] queries = scenario.queries();
    assertThat(arrayManipulation(arrLength, queries)).isEqualTo(expectedMax);
  }

  private enum Scenario {
    MINIMAL(1, 0) {
      @Override
      int[][] queries() {
        return arr();
      }
    }, EXAMPLE(5, 200) {
      @Override
      int[][] queries() {
        return arr(
            query(1, 2, 100),
            query(2, 5, 100),
            query(3, 4, 100)
                  );
      }
    }, TEST_CASE2(10, 31) {
      @Override
      int[][] queries() {
        return arr(
            query(2, 6, 8),
            query(3, 5, 7),
            query(1, 8, 1),
            query(5, 9, 15)
                  );
      }
    }, GIGANTO(4000, 30000) {
      @Override
      int[][] queries() {
        return fromFile("arrayQuery1.txt");
      }
    };

    private final int arrLength;
    private final long expectedMax;

    Scenario(int arrLength, long expectedMax) {
      this.arrLength = arrLength;
      this.expectedMax = expectedMax;
    }

    abstract int[][] queries();


  }

}