package sean.hackerrank.strings;

import java.util.BitSet;

public class TwoStrings {

  static final String YES = "YES";
  static final String NO = "NO";

  static String twoStrings(String s1, String s2) {

    BitSet bs1 = new BitSet(26);
    BitSet bs2 = new BitSet(26);

    for (int i = 0; i < s1.length(); i++) {
      int offset = s1.charAt(i) - 'a';
      bs1.set(offset);
    }
    for (int i = 0; i < s2.length(); i++) {
      int offset = s2.charAt(i) - 'a';
      bs2.set(offset);
    }
    return bs1.intersects(bs2) ? YES : NO;
  }

}
