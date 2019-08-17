package sean.hackerrank.strings;

// https://www.hackerrank.com/challenges/sherlock-and-valid-string
public class SherlockAndValidString {
    static String isValid(String s) {

        int[] frequencies = new int[26];
        for (int i = 0; i < s.length(); i++) {
            frequencies[s.charAt(i) - 'a']++;
        }

        Integer exception = null;
        Integer last = null;
        for (int frequency : frequencies) {
            if (frequency == 0) continue;
            if (last != null) {
                if (frequency != last) {
                    int bigger = Math.max(frequency, last);
                    int smaller = Math.min(frequency, last);
                    if (exception == null && bigger - 1 == smaller) {
                        exception = bigger;
                        continue;

                    } else if (exception == null && smaller == 1) {
                        exception = smaller;
                        continue;
                    } else {
                        return "NO";
                    }
                }
            }
            last = frequency;
        }
        return "YES";

    }

}
