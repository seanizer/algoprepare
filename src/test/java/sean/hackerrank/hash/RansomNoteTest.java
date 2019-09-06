package sean.hackerrank.hash;


import static org.assertj.core.api.Assertions.assertThat;
import static sean.hackerrank.hash.RansomNote.doCheckMagazine;
import static sean.util.ArrayHelper.arr;

import org.junit.jupiter.api.Test;

class RansomNoteTest {

  @Test
  void sampleInput0() {
    assertThat(
        doCheckMagazine(arr("give", "me", "one", "grand", "today"),
                        arr("give", "one", "grand", "today"))
              ).isEqualTo("Yes");
  }

  @Test
  void sampleInput1() {
    assertThat(
        doCheckMagazine(arr("two", "times", "three", "is", "not", "four"),
                        arr("two", "times", "two", "is", "four"))
              ).isEqualTo("No");
  }


}