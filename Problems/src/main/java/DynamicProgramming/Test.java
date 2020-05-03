package DynamicProgramming;

import javafx.util.Pair;

import java.util.HashMap;

public class Test {

    public static int min(int a, int b){
        return a <= b ? a : b;
    }

    public static int max(int a, int b){
        return a >= b ? a : b;
    }

    private static HashMap<Pair<Integer, Integer>, Integer> cache = new HashMap<>();

    public static int getMinEggDrops(int eggs, int floors) {
        if (eggs == 1) {
            return floors;
        }
        if (floors == 0) {
            return 0;
        }
        if (floors <= 2) {
            return 1;
        }

        Pair<Integer,Integer> cacheKey = new Pair<>(eggs, floors);
        if (cache.containsKey(cacheKey))
            return cache.get(cacheKey);

        int minAttempts = Integer.MAX_VALUE;
        for (int i = 1; i <= floors; i++) {
            int brokenEggAttempts = getMinEggDrops(eggs-1, i - 1);
            int unbrokenEggAttempts = getMinEggDrops(eggs, floors - i);
            minAttempts = min(minAttempts, max(brokenEggAttempts, unbrokenEggAttempts));
        }
        int result = minAttempts + 1;
        cache.put(cacheKey, result);
        return result;
    }

    public static void main(String[] args){
        System.out.println(getMinEggDrops(2, 100));
    }
}


