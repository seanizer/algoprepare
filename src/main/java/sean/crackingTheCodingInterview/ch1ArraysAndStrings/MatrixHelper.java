package sean.crackingTheCodingInterview.ch1ArraysAndStrings;

class MatrixHelper {

  static String drawMatrix(int[][] matrix) {
    StringBuilder sb = new StringBuilder();
    sb.append('\n');
    for (int rowIndex = 0; rowIndex < matrix.length; rowIndex++) {
      int[] row = matrix[rowIndex];
      for (int colIndex = 0; colIndex < row.length; colIndex++) {
        if (row[colIndex] < 10) {
          sb.append(' ');
        }
        sb.append(row[colIndex]);
        if (colIndex < row.length - 1 || rowIndex < matrix.length - 1) {
          sb.append(", ");
        }
      }
      sb.append('\n');

    }
    return sb.toString();
  }

  static int[][] rows(int[]... rows) {
    return rows;
  }

  static int[] row(int... cells) {
    return cells;
  }
}
