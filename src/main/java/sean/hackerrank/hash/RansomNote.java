package sean.hackerrank.hash;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RansomNote {

    static void checkMagazine(String[] magazine, String[] note) {
        MultiSet<String> ms = new MultiSet<>();
        ms.addAll(Arrays.asList(magazine));
        for (String word : note) {
            if (!ms.removeOne(word)) {
                System.out.println("No");
                return;

            }
        }
        System.out.println("Yes");

    }

    static class MultiSet<T> {
        private final Map<T, Integer> map = new HashMap<>();

        public void addAll(List<T> items) {
            for (T item : items) {
                int value = (map.getOrDefault(item, 0)) + 1;
                map.put(item, value);
            }
        }

        public boolean removeOne(T item) {
            if (map.containsKey(item)) {
                int value = map.get(item);
                if (value == 1) map.remove(item);
                else map.put(item, value - 1);
                return true;
            }
            return false;
        }
    }
}
