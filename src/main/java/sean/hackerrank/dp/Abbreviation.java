package sean.hackerrank.dp;

import java.util.HashSet;
import java.util.Set;

// https://www.hackerrank.com/challenges/abbr
public class Abbreviation {

    public static final String YES = "YES";
    public static final String NO = "NO";

    static String abbreviation(String a, String b) {
        if (a.length() >= b.length()) {
            Set<Integer> prefixes = new HashSet<>();
            prefixes.add(0);
            for (int i = 0; i < a.length(); i++) {
                char c = a.charAt(i);
                boolean isLower = Character.isLowerCase(c);
                char up = Character.toUpperCase(c);
                Set<Integer> newPrefixes = new HashSet<>(prefixes.size() * 2);
                for (Integer prefix : prefixes) {
                    int newPrefix = prefix + 1;
                    boolean isPrefix = prefix < b.length() && b.charAt(prefix) == up;
                    if (isLower) {
                        if (isPrefix) {
                            newPrefixes.add(newPrefix);
                        }
                        newPrefixes.add(prefix);
                    } else {
                        if (isPrefix) {
                            newPrefixes.add(newPrefix);
                        }
                    }
                }
                prefixes = newPrefixes;
            }
            if (prefixes.stream().anyMatch((i) -> i == b.length())) {
                return YES;
            }


        }
        return NO;

    }

}
