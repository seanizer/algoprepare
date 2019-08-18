package sean.hackerrank.strings;

import java.util.Arrays;

public class AnagramMaker {

  static int makeAnagram(String a, String b) {
    int result = 0;

    char[] a1 = a.toCharArray();
    Arrays.sort(a1);
    char[] a2 = b.toCharArray();
    Arrays.sort(a2);

    int leftOffset = 0, rightOffset = 0;
    while (true) {
      if (leftOffset == a1.length) {
        result += a2.length - rightOffset;
        break;
      }
      if (rightOffset == a2.length) {
        result += a1.length - leftOffset;
        break;
      }
      char left = a1[leftOffset];
      char right = a2[rightOffset];

      if (left < right) {
        result++;
        leftOffset++;
      } else if (right < left) {
        result++;
        rightOffset++;
      } else {
        leftOffset++;
        rightOffset++;
      }
    }
    return result;
  }

}
