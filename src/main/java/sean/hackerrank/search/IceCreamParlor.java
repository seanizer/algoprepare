package sean.hackerrank.search;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class IceCreamParlor {
    static void whatFlavors(int[] cost, int money) {
        System.out.println(
                Arrays.stream(returnWhatFlavors(cost, money))
                      .boxed()
                      .map(Object::toString)
                      .collect(Collectors.joining(" "))
        );
    }

    static int[] returnWhatFlavors(int[] cost, int money) {
        Map<Integer, Set<Integer>> offsetByCost = new HashMap<>();
        for (int i = 0; i < cost.length; i++) {
            int offset = i + 1;
            offsetByCost.compute(cost[i], (ii, s) -> {
                Set<Integer> set = s == null ? new HashSet<>() : s;
                set.add(offset);
                return set;
            });
        }
        int half = money / 2;
        int secondHalf = money - half;
        if (half == secondHalf) {
            Set<Integer> result = offsetByCost.getOrDefault(half, Collections.emptySet());
            if (result.size() > 1) return result.stream().sorted().limit(2).mapToInt(Integer::intValue).toArray();
        }
        for (Map.Entry<Integer, Set<Integer>> entry : offsetByCost.entrySet()) {
            int cost1 = entry.getKey();
            if (cost1 == half) continue;
            if (cost1 < money) {
                int cost2 = money - cost1;
                if (offsetByCost.containsKey(cost2)) {
                    Set<Integer> offsets1 = entry.getValue();
                    Set<Integer> offsets2 = offsetByCost.get(cost2);
                    return
                            Stream.of(offsets1, offsets2)
                                  .flatMap(s -> s.stream().sorted().limit(1))
                                  .sorted()
                                  .mapToInt(Integer::intValue)
                                  .toArray();
                }
            }

        }
        throw new IllegalStateException(String.format("Found no solution for cost: %s, money: %s", Arrays.toString(cost), money));

    }
}
