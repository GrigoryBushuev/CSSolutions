package Recursion;

import java.util.*;

public class Fibonacci {
    private static HashMap<Integer, Integer> cache = new HashMap<>();

    public static int fib(int N) {
        if (N < 2) {
            return N;
        }

        Integer result = cache.get(N);
        if (result == null) {
            result = fib(N-1) + fib(N - 2);
            cache.put(N, result);
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(fib(6));
    }
}
