package sean.crackingTheCodingInterview.ch1ArraysAndStrings;

public class StringCompress {
    static String compress(String input) {
        if (input.length() > 2) {

            char lastChar = input.charAt(0);
            int runLength = 1;
            StringBuilder sb = new StringBuilder();
            for (int i = 1; i < input.length(); i++) {
                char c = input.charAt(i);
                if (c == lastChar) runLength++;
                else {
                    sb.append(lastChar).append(runLength);
                    lastChar = c;
                    runLength = 1;
                }
            }
            sb.append(lastChar).append(runLength);
            if (sb.length() < input.length()) return sb.toString();
        }

        return input;
    }
}
