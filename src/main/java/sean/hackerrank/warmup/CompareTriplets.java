package sean.hackerrank.warmup;

import java.util.Arrays;
import java.util.List;

// https://www.hackerrank.com/challenges/compare-the-triplets
public class CompareTriplets {
    static List<Integer> compareTriplets(List<Integer> a, List<Integer> b) {
        List<Integer> result = Arrays.asList(0, 0);


        for (int i = 0; i < 3; i++) {
            int comparison = Integer.compare(a.get(i), b.get(i));
            if (comparison < 0) result.set(0, result.get(0) + 1);
            else if (comparison > 0) result.set(1, result.get(1) + 1);
        }

        return result;

    }
}
