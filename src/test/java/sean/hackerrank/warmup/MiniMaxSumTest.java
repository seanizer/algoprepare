package sean.hackerrank.warmup;

import static org.assertj.core.api.Assertions.assertThat;
import static sean.hackerrank.warmup.MiniMaxSum.miniMaxSum;
import static sean.util.ArrayHelper.arr;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MiniMaxSumTest {

  private ByteArrayOutputStream baos;
  private PrintStream oldOut;

  @BeforeEach
  void setUp() {
    oldOut = System.out;
    baos = new ByteArrayOutputStream();
    System.setOut(new PrintStream(baos));
  }

  @AfterEach
  void tearDown() {
    System.setOut(oldOut);
  }

  String readOutput(Runnable r) {
    try {
      r.run();
      baos.flush();
      return new String(baos.toByteArray());
    } catch (IOException e) {
      throw new IllegalStateException(e);
    }
  }


  @Test
  void sampleInput() {
    assertThat(readOutput(() -> miniMaxSum(arr(1, 2, 3, 4, 5)))).isEqualTo("10 14\n");
  }
}