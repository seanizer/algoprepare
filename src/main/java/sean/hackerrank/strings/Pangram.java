package sean.hackerrank.strings;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.IntStream;

public class Pangram {

    public static final String PANGRAM = "pangram";
    public static final String NO_PANGRAM = "no pangram";

    static String pangrams(String input) {
        String s = input.toLowerCase();
        boolean result = false;
        if (s.length() >= 26) {
            Set<Character> missingChars = new HashSet<>(26);
            IntStream.range(0, 26).mapToObj(i -> (char) ('a' + i)).forEach(missingChars::add);
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                missingChars.remove(c);
                if (missingChars.isEmpty()) {
                    result = true;
                    break;
                }
            }
        } else result = false;
        return result ? PANGRAM : NO_PANGRAM;

    }

}
