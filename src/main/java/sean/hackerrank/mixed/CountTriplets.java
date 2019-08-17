package sean.hackerrank.mixed;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

// https://www.hackerrank.com/challenges/count-triplets-1
public class CountTriplets {
    static long countTriplets(List<Long> arr, long r) {
        Map<Long, Long> t2 = new HashMap<>();
        Map<Long, Long> t3 = new HashMap<>();
        long result = 0L;

        for (Long a : arr) {
            result += t3.getOrDefault(a, 0L);
            if (t2.containsKey(a)) {
                t3.put(a * r, t3.getOrDefault(a * r, 0L) + t2.get(a));
            }
            t2.put(a * r, t2.getOrDefault(a * r, 0L) + 1);
        }
        return result;
    }

}
