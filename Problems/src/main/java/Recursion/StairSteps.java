package Recursion;

import java.util.*;

public class StairSteps {
    private static ArrayList<ArrayList<Integer>> getStairsSteps(int n) {
        var result = new ArrayList<ArrayList<Integer>>();
        if (n == 0) {
            result.add(new ArrayList<>());
            return result;
        }
        
        for (var i = 1; i <= 3 && i <= n; i++) {
            result.addAll(getStairsSteps(n - i));
        }
        for (var comb : result) {
            comb.add(n);
        }
        return result;
    }

    public static void main(String[] args) {
        for (var combination : getStairsSteps(6)) {
            System.out.println();
            System.out.print("[");
            for (var step : combination) {
                System.out.print("," + step);
            }
            System.out.print("]");
        }
    }
}
