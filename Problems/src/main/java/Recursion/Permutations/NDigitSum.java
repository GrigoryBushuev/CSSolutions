package Recursion.Permutations;
import java.util.*;

/*
Given number of digits n, print all n-digit numbers whose sum of digits adds upto given sum. Solution should not consider leading 0’s as digits.
Examples:
Input:  N = 2, Sum = 3
Output:  12 21 30

Input:  N = 3, Sum = 6
Output:  105 114 123 132 141 150 204
         213 222 231 240 303 312 321
         330 402 411 420 501 510 600

Input:  N = 4, Sum = 3
Output:  1002 1011 1020 1101 1110 1200
         2001 2010 2100 3000

Time complexity:
    Branching factor: 10
    Depth of recursion: N
    Work to convert the list to integer: N
    Time complexity: O(N * 10^N)

Space complexity:
    Depth of recursion: N
    Space per frame: N
    Branching factor: 10
    Space complexity: O(N * 10^N)

*/
public class NDigitSum {
    public static List<Integer> getNDigitSum(int n, int sum) {
        LinkedList<Integer> result = new LinkedList<>();
        getNDigitSum(n, sum, 0, new ArrayList<>(), result);
        return result;
    }

    private static void getNDigitSum(int n, int sum, int runningTotal, List<Integer> path, LinkedList<Integer> result) {
        if (path.size() == n && runningTotal == sum) {
            result.add(listToInteger(path));
            return;
        }
        for (int i = 0; i <= 9; i++) {
            if (path.size() == 2 || path.isEmpty() && i == 0) {
                continue;
            }
            path.add(i);
            runningTotal += i;
            getNDigitSum(n, sum, runningTotal, path, result);
            runningTotal -= i;
            path.remove(path.size() - 1);
        }
    }

    private static Integer listToInteger(List<Integer> list) {
        int result = 0;
        for (int i = 0; i < list.size(); i++) {
            result += list.get(i) * Math.pow(10, list.size() - i - 1);
        }
        return result;
    }
}
