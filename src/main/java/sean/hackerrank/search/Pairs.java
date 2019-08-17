package sean.hackerrank.search;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

// https://www.hackerrank.com/challenges/pairs
public class Pairs {
    static int pairs(int k, int[] arr) {
        Set<Integer> uniqueValues = new HashSet<>();
        Arrays.stream(arr).forEach(uniqueValues::add);
        int pairs = 0;
        for (int v : uniqueValues) {
            if (uniqueValues.contains(v - k)) pairs++;
        }
        return pairs;
    }
}
