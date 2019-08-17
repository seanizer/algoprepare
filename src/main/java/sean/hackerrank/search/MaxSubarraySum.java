package sean.hackerrank.search;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;

// https://www.hackerrank.com/challenges/maximum-subarray-sum
public class MaxSubarraySum {
    static long maximumSum(long[] a, long m) {
        Map<Long, Integer> frequenciesByValue = new HashMap<>();
        Arrays.stream(a).forEach(l -> frequenciesByValue.compute(l % m, (k, v) -> (v == null ? 0 : v) + 1));
        Set<Long> keys = new HashSet<>(frequenciesByValue.keySet());
        AtomicLong max = new AtomicLong(0);
        AtomicBoolean stop = new AtomicBoolean(false);

        for (long key : keys) {
            checkMod(key, Collections.emptyList(), frequenciesByValue, max, stop, m);
        }
        return max.get();


    }

    private static void checkMod(long key, List<Long> context, Map<Long, Integer> frequenciesByValue, AtomicLong max, AtomicBoolean stop, long target) {
        if (stop.get()) return;
        try {
            frequenciesByValue.compute(key, (k, v) -> v == 1 ? null : v - 1);
            long modSum = context.stream().mapToLong(Long::longValue).sum() + key;
            if (modSum == target - 1) {
                max.set(modSum);
                stop.set(true);
            } else if (modSum >= target) return;
            for (long newKey : frequenciesByValue.keySet()) {
                checkMod(newKey, append(context, key), frequenciesByValue, max, stop, target);
            }
        } finally {
            frequenciesByValue.compute(key, (k, v) -> v == null ? 1 : v + 1);
        }

    }

    private static List<Long> append(List<Long> list, long element) {
        if (list.isEmpty()) return Collections.singletonList(element);
        else {
            List<Long> newlist = new ArrayList<>(list.size() + 1);
            newlist.addAll(list);
            newlist.add(element);
            return newlist;
        }
    }
}
