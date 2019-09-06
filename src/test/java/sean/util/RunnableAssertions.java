package sean.util;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import org.assertj.core.api.ListAssert;

public class RunnableAssertions {

  public static ListAssert<String> assertThatOutputOf(Runnable runnable) {
    ByteArrayOutputStream baos = new ByteArrayOutputStream();
    PrintStream oldOut = System.out;
    try {
      System.setOut(new PrintStream(baos));
      runnable.run();
      baos.flush();
    } catch (IOException e) {
      throw new IllegalStateException(e);
    } finally {
      System.setOut(oldOut);
    }
    return assertThat(
        Arrays.asList(
            new String(baos.toByteArray(), StandardCharsets.UTF_8).split("\n")));

  }

}
