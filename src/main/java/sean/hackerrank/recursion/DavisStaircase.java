package sean.hackerrank.recursion;

import java.util.HashMap;
import java.util.Map;

// https://www.hackerrank.com/challenges/ctci-recursive-staircase
public class DavisStaircase {
    static int stepPerms(int n) {
        Map<Integer, Integer> cache = new HashMap<>();
        return calc(n, cache);
    }

    private static int calc(int n, Map<Integer, Integer> cache) {
        return cache.computeIfAbsent(n, input -> {
            switch (n) {
                case 0:
                case 1:
                case 2:
                    return n;
                case 3:
                    return 4;
                default:
                    return calc(n - 1, cache) + calc(n - 2, cache) + calc(n - 3, cache);
            }
        });
    }
}
