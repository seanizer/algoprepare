package sean.crackingTheCodingInterview.ch1ArraysAndStrings;

public class ZeroMatrix {

    static void zeroMatrix(int[][] matrix) {
        boolean[] zeroRow = new boolean[matrix.length];
        boolean[] zeroCol = new boolean[matrix[0].length];

        for (int rowIndex = 0; rowIndex < matrix.length; rowIndex++) {
            int[] row = matrix[rowIndex];
            for (int colIndex = 0; colIndex < row.length; colIndex++) {
                int cell = row[colIndex];
                if (cell == 0) {
                    zeroRow[rowIndex] = true;
                    zeroCol[colIndex] = true;
                }
            }
        }

        for (int rowIndex = 0; rowIndex < zeroRow.length; rowIndex++) {
            int[] row = matrix[rowIndex];
            for (int colIndex = 0; colIndex < row.length; colIndex++) {
                if (zeroRow[rowIndex] || zeroCol[colIndex]) row[colIndex] = 0;
            }
        }
    }
}
