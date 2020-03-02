package DynamicProgramming;

import java.util.HashMap;
import java.util.Map;

/*
You are climbing a stair case. It takes n steps to reach to the top.
Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
Note: Given n will be a positive integer.
*/

class ClimbStairs {
    public static int getStairsNumber(int n) {
        Map<Integer, Integer> cache = new HashMap<>(n);
        return getStairsNumber(n, cache);
    }

    private static int getStairsNumber(int n, Map<Integer, Integer> cache) {
        if (n == 3) return 3;
        if (n == 2) return 2;
        if (n == 1) return 1;
        if (n <= 0) return 0;

        if (!cache.containsKey(n)) {
            int result = getStairsNumber(n-2, cache) + getStairsNumber(n-1, cache);
            cache.put(n, result);
        }
        return cache.get(n);
    }

    public static void main(String[] args) {
        System.out.println(ClimbStairs.getStairsNumber(40));
    }
}
