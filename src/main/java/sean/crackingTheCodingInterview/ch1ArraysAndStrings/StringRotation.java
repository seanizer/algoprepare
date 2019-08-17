package sean.crackingTheCodingInterview.ch1ArraysAndStrings;

class StringRotation {


    static boolean isRotated(String first, String second) {
        if (first.length() != second.length()) return false;
        if (first.length() < 2) return true;
        return ((second + second).contains(first) || (first + first).contains(second));
    }
}
