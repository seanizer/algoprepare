package sean.dailycoding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public interface NSteps {

  static NSteps get() {
    return new Solution();
  }

  Set<List<Integer>> possibleStepPatterns(int length, Set<Integer> allowedSteps);

  default Set<List<Integer>> possibleStepPatternsForNLt3(int length) {
    return possibleStepPatterns(length, new HashSet<>(Arrays.asList(1, 2)));
  }

  class Solution implements NSteps {

    static <T> List<T> append(List<T> input, T element) {
      List<T> newList = new ArrayList<>(input);
      newList.add(element);
      return newList;
    }

    @Override
    public Set<List<Integer>> possibleStepPatterns(int length, Set<Integer> allowedSteps) {
      Set<List<Integer>> result = new HashSet<>();
      gatherStepPatterns(length, Collections.unmodifiableSet(allowedSteps), Collections.emptyList(),
                         0, result);
      return result;
    }

    private void gatherStepPatterns(int totalLength, Set<Integer> allowedSteps,
                                    List<Integer> previousSteps, int currentLength,
                                    Set<List<Integer>> result) {
      for (Integer possibleStep : allowedSteps) {
        int newLength = currentLength + possibleStep;
        if (newLength == totalLength) {
          result.add(append(previousSteps, possibleStep));
        } else if (newLength < totalLength) {
          gatherStepPatterns(totalLength, allowedSteps, append(previousSteps, possibleStep),
                             currentLength + possibleStep, result);
        }
      }
    }
  }

}
