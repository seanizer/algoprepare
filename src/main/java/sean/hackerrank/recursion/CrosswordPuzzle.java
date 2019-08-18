package sean.hackerrank.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// https://www.hackerrank.com/challenges/crossword-puzzle/problem
public class CrosswordPuzzle {

  static String[] crosswordPuzzle(String[] crossword, String wordsAsString) {
    char[][] matrix = toMatrix(crossword);
    List<Point> points = detectStartingPoints(matrix);
    List<String> words = split(wordsAsString);
    insertWordsIntoMatrix(matrix, points, words);
    return fromMatrix(matrix);
  }

  private static void insertWordsIntoMatrix(char[][] matrix, List<Point> points,
                                            List<String> words) {

  }

  private static List<String> split(String wordsAsString) {
    return Arrays.asList(wordsAsString.split(";"));
  }

  private static List<Point> detectStartingPoints(char[][] matrix) {

    List<Point> result = new ArrayList<>();
    int currentColOffset = -1;
    boolean vertical = true;

    for (int rowIndex = 0; rowIndex < matrix.length; rowIndex++) {
      char[] row = matrix[rowIndex];
      for (int colIndex = 0; colIndex < row.length; colIndex++) {
        char c = row[colIndex];
        if (c == '-') {
          if (vertical) {
            currentColOffset = colIndex;
            vertical = false;
            result.add(new Point(colIndex, rowIndex));
            break;
          } else {
            if (colIndex != currentColOffset) {
              currentColOffset = colIndex;
              vertical = false;
              break;
            }

          }
        }
      }
    }
    return result;
  }

  static char[][] toMatrix(String[] input) {
    return Arrays.stream(input).map(String::toCharArray).toArray(char[][]::new);
  }

  static String[] fromMatrix(char[][] input) {
    return Arrays.stream(input).map(String::new).toArray(String[]::new);
  }

  static class Point {

    final int x;
    final int y;

    Point(int x, int y) {
      this.x = x;
      this.y = y;
    }
  }
}
