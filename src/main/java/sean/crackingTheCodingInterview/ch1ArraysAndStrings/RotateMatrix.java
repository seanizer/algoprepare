package sean.crackingTheCodingInterview.ch1ArraysAndStrings;

/*
Rotate Matrix: Given an image represented by an NxN matrix, where each pixel in the image is 4
bytes, write a method to rotate the image by 90 degrees. Can you do this in place?
 */
public class RotateMatrix {

  static void rotateClockwise(int[][] matrix) {
    int size = matrix.length - 1;
    int xmidPoint = (matrix.length) / 2;
    int ymidPoint = (matrix.length) / 2 + (matrix.length % 2 == 0 ? 0 : 1);
    for (int i = 0; i < xmidPoint; i++) {
      for (int j = 0; j < ymidPoint; j++) {
        int temp = matrix[i][j];
        matrix[i][j] = matrix[size - j][i];                  //   1,  2,  3,  4     0,1
        matrix[size - j][i] = matrix[size - i][size - j];    //   5,  6,  7,  8     2,0
        matrix[size - i][size - j] = matrix[j][size - i];    //   9, 10, 11, 12     3,2
        matrix[j][size - i] = temp;                          //  13, 14, 15, 16     1,3
      }
    }
  }

}
