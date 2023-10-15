package Recursion.Subproblems;

import java.util.*;

/*●
Given a staircase of height N, write a function that finds all of the ways you
can get to the top of the staircase taking steps of size 1, 2, or 3

From any given step, 3 different options
Reduces the number of remaining steps -> subproblem!
Combine the combinations it takes to get to one step with the
combinations it takes to get from that step to the end
*/
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
