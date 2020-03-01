package DynamicProgramming;

import java.util.HashMap;
import java.util.Map;

public class EggDropProblem {
    private static int Min(int a, int b) {
        return a <= b ? a : b;
    }

    private static int Max(int a, int b) {
        return a >= b ? a : b;
    }

    int eggs;
    int floors;
    private Map<Integer, Integer> cache = null;

    public EggDropProblem(int eggs, int floors) {
        this.eggs = eggs;
        this.floors = floors;
        this.cache = new HashMap<>(eggs * floors);
    }

    private int getKey(int eggs, int floors) {
        return eggs * this.floors + floors;
    }

    public int getNumberOfDrops() {
        return getNumberOfDrops(this.eggs, this.floors);
    }

    private int getNumberOfDrops(int eggs, int floors) {
        int cacheKey = getKey(eggs, floors);
        if (!cache.containsKey(cacheKey)) {
            if (eggs == 1 || floors < 2) {
                return floors;
            }
            int result = Integer.MAX_VALUE;
            for (int i = 1; i <= floors; i++) {
                result = Min(Max(getNumberOfDrops(eggs - 1, i - 1), getNumberOfDrops(eggs, floors - i)), result);
            }
            cache.put(cacheKey, result + 1);
        }
        return cache.get(getKey(eggs, floors));
    }

    public static void main(String[] args) {
        EggDropProblem problem = new EggDropProblem(2, 100);
        System.out.println(problem.getNumberOfDrops());
    }
}
