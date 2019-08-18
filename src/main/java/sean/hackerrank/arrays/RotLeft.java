package sean.hackerrank.arrays;

// https://www.hackerrank.com/challenges/ctci-array-left-rotation
public class RotLeft {

  static int[] rotLeft(int[] a, int d) {

    if (d == 0) {
      return a;
    }
    int[] b = new int[a.length];
    int complement = a.length - d;
    System.arraycopy(a, d, b, 0, complement);
    System.arraycopy(a, 0, b, complement, d);
    return b;

  }

}
