package sean.crackingTheCodingInterview.ch1ArraysAndStrings;

import java.util.Arrays;

public class ReverseCStyleString {

  static char[] toCStyleString(String s) {
    char[] chars = Arrays.copyOf(s.toCharArray(), s.length() + 1);
    chars[s.length()] = (char) 0;
    return chars;
  }

  static char[] reverseCStyleStringInPlace(char[] input) {
    if (input.length > 2) {
      int middle = (input.length - 1) / 2;
      int endOffset = input.length - 2;
      for (int i = 0; i < middle; i++) {
        char temp = input[i];
        input[i] = input[endOffset - i];
        input[endOffset - i] = temp;
      }
    }
    return input;
  }

  static char[] reverseCStyleStringCopy(char[] input) {
    if (input.length < 3) {
      return Arrays.copyOf(input, input.length);
    }
    char[] output = new char[input.length];
    int end = input.length - 1;
    output[end] = input[end];
    for (int i = 0; i < end; i++) {
      int tailOffset = end - (i + 1);
      output[i] = input[tailOffset];
    }
    return output;
  }
}
