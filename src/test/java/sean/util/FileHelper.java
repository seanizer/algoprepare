package sean.util;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FileHelper {

  public static int[] intArrayFromFile(String filename) {
    String str = readFileToString(filename);
    return stringToIntArray(str);
  }

  public static int[][] intArraysFromFile(String filename) {
    String str = readFileToString(filename);
    return Arrays.stream(str.split("\n")).map(FileHelper::stringToIntArray).toArray(int[][]::new);
  }

  public static String readFileToString(String filename) {
    try {
      URL stream = FileHelper.class.getResource("/" + filename);
      File file = new File(stream.toURI());
      return new String(Files.readAllBytes(file.toPath()));
    } catch (IOException | URISyntaxException e) {
      throw new IllegalStateException(e);
    }
  }

  private static int[] stringToIntArray(String str) {
    List<Integer> ints = new LinkedList<>();
    Matcher matcher = Pattern.compile("-?\\d+").matcher(str);
    while (matcher.find()) {
      ints.add(Integer.parseInt(matcher.group()));
    }
    return ints.stream().mapToInt(Integer::intValue).toArray();
  }

  public static long[] stringToLongArray(String fileName) {
    return Arrays.stream(readFileToString(fileName).split("\\s+"))
                 .mapToLong(Long::parseLong)
                 .toArray();
  }
}
