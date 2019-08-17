package sean.hackerrank.mixed;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

// https://www.hackerrank.com/challenges/frequency-queries
public class FreqQueries {

    static List<Integer> freqQuery(List<List<Integer>> queries) {
        List<Integer> result = new ArrayList<>();
        List<Integer> data = new ArrayList<>();
        Map<Integer, Function<Integer, Boolean>> mapa = new HashMap<>();
        mapa.put(1, data::add);
        mapa.put(2, data::remove);
        mapa.put(3, o -> {
            Map<Integer, Long> counts = data.stream().collect(Collectors.groupingBy(e -> e, Collectors.counting()));
            return result.add(counts.containsValue(new Long(o)) ? 1 : 0);
        });
        queries.forEach(integers -> {
            mapa.get(integers.get(0)).apply(integers.get(1));
        });
        return result;
    }

}
