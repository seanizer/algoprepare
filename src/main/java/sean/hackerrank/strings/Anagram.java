package sean.hackerrank.strings;

// https://www.hackerrank.com/challenges/anagram
public class Anagram {
    static int anagram(String s) {
        String left = s.substring(0, s.length() / 2);
        String right = s.substring(s.length() / 2);
        if (left.length() != right.length()) return -1;
        int[] leftChars = frequencies(left);
        int[] rightChars = frequencies(right);
        int differences = 0;
        for (int i = 0; i < leftChars.length; i++) {
            differences += Math.abs(leftChars[i] - rightChars[i]);
        }
        return differences / 2;
    }

    private static int[] frequencies(String s) {
        int[] fr = new int[26];
        for (int i = 0; i < s.length(); i++) {
            int offset = s.charAt(i) - 'a';
            fr[offset]++;
        }
        return fr;
    }
}
