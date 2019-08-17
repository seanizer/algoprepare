package sean.hackerrank.recursion;

public class Fibonacci {
    public static int fibonacci(int n) {
        if (n < 0) throw new IllegalArgumentException("0 or more required");
        if (n < 2) return n;
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

}
