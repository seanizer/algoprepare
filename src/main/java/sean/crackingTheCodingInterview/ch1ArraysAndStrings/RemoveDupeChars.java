package sean.crackingTheCodingInterview.ch1ArraysAndStrings;

import java.util.Arrays;

public class RemoveDupeChars {

  private static final char NULL = (char) 0;

  interface DupeRemover {

    void removeDupes(char[] input);
  }

  static class NestedLoopDupeRemover implements DupeRemover {

    @Override
    public void removeDupes(char[] input) {
      int endOffset = input.length - 1;
      for (int i = 0; i < endOffset; i++) {
        for (int j = i + 1; j < input.length; j++) {
          if (input[i] == NULL) {
            break;
          }
          if (input[i] == input[j]) {
            char temp = input[endOffset];
            input[endOffset] = NULL;
            input[j] = temp;
            endOffset--;
          }
        }
      }
    }
  }

  static class BitMaskDupeRemover implements DupeRemover {

    @Override
    public void removeDupes(char[] input) {
      boolean[] mask = new boolean[256];
      for (int i = 0; i < input.length; i++) {
        char c = input[i];
        int offset = (int) c;
        mask = autoGrow(mask, offset);
        if (mask[offset]) {
          input[i] = NULL;
        } else {
          mask[offset] = true;
        }
      }
    }

    private boolean[] autoGrow(boolean[] mask, int offset) {
      if (mask.length > offset) {
        return mask;
      } else {
        int newSize = mask.length;
        while (newSize < offset) {
          newSize *= 2;
        }
        return Arrays.copyOf(mask, newSize);
      }
    }
  }

}
