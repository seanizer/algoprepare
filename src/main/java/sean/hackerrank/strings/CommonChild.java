package sean.hackerrank.strings;

// https://www.hackerrank.com/challenges/common-child
public class CommonChild {
    static int commonChild(String first, String second) {
        int[][] storage = new int[first.length() + 1][second.length() + 1];

        for (int i = 0; i < first.length(); i++) {
            for (int j = 0; j < second.length(); j++) {
                if (first.charAt(i) == second.charAt(j)) {
                    storage[i + 1][j + 1] = storage[i][j] + 1;
                } else {
                    storage[i + 1][j + 1] = Math.max(storage[i + 1][j], storage[i][j + 1]);
                }
            }
        }

        return storage[first.length()][second.length()];
    }
}
