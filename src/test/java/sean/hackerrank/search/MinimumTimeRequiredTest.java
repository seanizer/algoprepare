package sean.hackerrank.search;

import static org.assertj.core.api.Assertions.assertThat;
import static sean.hackerrank.search.MinimumTimeRequired.minTime;
import static sean.util.ArrayHelper.longArr;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

class MinimumTimeRequiredTest {


  static long[] fromFile(String fileName) {
    try {
      File file = new File(MinimumTimeRequired.class.getResource("/" + fileName).toURI());
      return Arrays.stream(
          new String(Files.readAllBytes(file.toPath()), StandardCharsets.UTF_8).split("\\s+"))
                   .mapToLong(Long::parseLong)
                   .toArray();
    } catch (URISyntaxException | IOException e) {
      throw new IllegalStateException(e);
    }
  }

  @Test
  void sampleInput0() {
    assertThat(minTime(longArr(2, 3), 5)).isEqualTo(6);
  }

  @Test
  void sampleInput1() {
    assertThat(minTime(longArr(1, 3, 4), 10)).isEqualTo(7);
  }

  @Test
  void sampleInput2() {
    assertThat(minTime(longArr(4, 5, 6), 12)).isEqualTo(20);
  }

  @Test
  void testCase9() {
    assertThat(minTime(fromFile("minimumTimeRequired.txt"), 433551589L)).isEqualTo(269029389958L);
  }

}