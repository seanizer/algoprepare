package sean.hackerrank.dp;

import static org.assertj.core.api.Assertions.assertThat;
import static sean.hackerrank.dp.MaxArraySum.maxSubsetSum;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.junit.jupiter.api.Test;

class MaxArraySumTest {

  static int[] arr(int... items) {
    return items;
  }

  static int[] fromFile(String filename) {
    try {
      URL stream = MaxArraySum.class.getResource("/" + filename);
      File file = new File(stream.toURI());
      List<Integer> ints = new LinkedList<>();
      String str = new String(Files.readAllBytes(file.toPath()));
      Matcher matcher = Pattern.compile("-?\\d+").matcher(str);
      while (matcher.find()) {
        ints.add(Integer.parseInt(matcher.group()));
      }
      return ints.stream().mapToInt(Integer::intValue).toArray();
    } catch (URISyntaxException | IOException e) {
      throw new IllegalStateException(e);
    }

  }

  @Test
  void sampleInput1() {
    assertThat(maxSubsetSum(arr(2, 1, 5, 8, 4))).isEqualTo(11);
  }

  @Test
  void sampleInput2() {
    assertThat(maxSubsetSum(arr(3, 5, -7, 8, 10))).isEqualTo(15);
  }

  @Test
  void testCase3() {
    assertThat(maxSubsetSum(fromFile("maxArraySum1.txt"))).isEqualTo(107352889);

  }

  @Test
  void testCase30() {
    assertThat(maxSubsetSum(arr(3, 7, 4, 6, 5))).isEqualTo(13);

  }

}