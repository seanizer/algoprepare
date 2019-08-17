package sean.crackingTheCodingInterview.ch1ArraysAndStrings;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class StringUniqueCharacters {

    interface UniqueCharChecker {
        boolean hasUniqueChars(String s);
    }

    static class HashSetUniqueCharChecker implements UniqueCharChecker {
        @Override
        public boolean hasUniqueChars(String s) {
            Set<Character> chars = new HashSet<>();
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (chars.contains(c)) return false;
                chars.add(c);
            }
            return true;
        }
    }

    static class LongArrayUniqueCharChecker implements UniqueCharChecker {
        int bucketOffset(char c) {
            return (int) c / 64;
        }

        int relativeOffset(char c) {
            return (int) c % 64;
        }

        @Override
        public boolean hasUniqueChars(String s) {
            long[] mask = new long[4];
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                int bucket = bucketOffset(c);
                mask = autoGrow(mask, bucket);
                int offset = relativeOffset(c);
                long bucketValue = mask[bucket];
                if ((bucketValue & offset) != 0) return false;
                mask[bucket] = bucketValue | offset;

            }
            return true;
        }

        private long[] autoGrow(long[] mask, int bucket) {
            if (bucket < mask.length) return mask;
            return Arrays.copyOf(mask, bucket + mask.length);
        }
    }


}
