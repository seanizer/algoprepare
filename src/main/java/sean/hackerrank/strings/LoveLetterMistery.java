package sean.hackerrank.strings;

// https://www.hackerrank.com/challenges/the-love-letter-mystery
public class LoveLetterMistery {
    static int theLoveLetterMystery(String s) {

        int midPoint = s.length() / 2;
        int diff = 0;
        for (int i = 0; i < midPoint; i++) {
            char left = s.charAt(i);
            char right = s.charAt(s.length() - (i + 1));
            diff += Math.abs(left - right);
        }
        return diff;
    }
}
