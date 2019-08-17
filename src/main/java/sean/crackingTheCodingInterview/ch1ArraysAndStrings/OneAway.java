package sean.crackingTheCodingInterview.ch1ArraysAndStrings;

/*
One Away: There are three types of edits that can be performed on strings: insert a character,
remove a character, or replace a character. Given two strings, write a function to check if they are
one edit (or zero edits) away.
EXAMPLE
pale, ple -> true
pales, pale -> true
pale, bale -> true
pale, bake -> false
Hints:#23, #97, #130
 */
public interface OneAway {
    boolean oneAway(String left, String right);

    class BasicOneAway implements OneAway {
        @Override
        public boolean oneAway(String left, String right) {
            int leftLength = left.length();
            int rightLength = right.length();
            if (leftLength + 1 == rightLength) return checkAdd(left, right);
            else if (leftLength == rightLength) return checkSwap(left, right);
            else if (leftLength - 1 == rightLength) return checkAdd(right, left);
            else return false;
        }

        private boolean checkSwap(String left, String right) {
            int swaps = 0;
            for (int i = 0; i < left.length(); i++) {
                char leftChar = left.charAt(i);
                char rightChar = right.charAt(i);
                if (leftChar != rightChar) {
                    if (++swaps > 1) return false;
                }
            }
            return true;
        }

        private boolean checkAdd(String left, String right) {
            int adds = 0;
            for (int i = 0; i < left.length(); i++) {
                char leftChar = left.charAt(i);
                char rightChar = right.charAt(i + adds);
                if (leftChar != rightChar) {
                    if (++adds > 1) return false;
                }
            }
            return true;
        }
    }
}
