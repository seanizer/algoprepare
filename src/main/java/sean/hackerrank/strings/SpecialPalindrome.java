package sean.hackerrank.strings;

// https://www.hackerrank.com/challenges/special-palindrome-again
public class SpecialPalindrome {
    static long substrCount(int n, String s) {
        long count = 0;
        for (int start = 0; start < n; start++) {
            char curr = s.charAt(start);
            int end = start + 1;
            while (end < n && s.charAt(end) == curr) {
                count++;
                end++;
            }
            if (end < n) {
                int mid = end;
                end++;
                int equals = mid - start;
                while (end < n && end <= mid + equals && s.charAt(end) == curr) {
                    end++;
                }
                if (end - 1 - mid == mid - start) {
                    count++;
                }
            }
        }
        return count + n;

    }

    private static long countPalindromes(int runLength) {
        if (runLength == 1) return 1;
        return (runLength * (runLength + 1)) / 2;
    }

    private static boolean hasRun(int length, char c, String s, int offset) {
        if (s.length() >= length + offset) {
            for (int i = offset; i < length + offset; i++) {
                if (s.charAt(i) != c) return false;
            }
            return true;
        }
        return false;
    }
}
