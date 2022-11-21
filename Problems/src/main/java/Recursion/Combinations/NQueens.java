package Recursion.Combinations;

import java.util.ArrayList;
import java.util.List;

/*
51. N-Queens

The n-queens puzzle is the problem of placing n queens on an n x n chessboard such that no two queens attack each other.
Given an integer n, return all distinct solutions to the n-queens puzzle. You may return the answer in any order.
Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a queen and an empty space, respectively.

Example 1:

Input: n = 4
Output: [[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
Explanation: There exist two distinct solutions to the 4-queens puzzle as shown above

Example 2:

Input: n = 1
Output: [["Q"]]

Constraints:
1 <= n <= 9
*
*/

/*Time complexity: O(N!)O(N!)O(N!)
Unlike the brute force approach, we will only place queens on squares that aren't under attack.
For the first queen, we have N options.
For the next queen, we won't attempt to place it in the same column as the first queen, and there must be at least one square attacked diagonally by the first queen as well.
Thus, the maximum number of squares we can consider for the second queen is N−2.
For the third queen, we won't attempt to place it in 2 columns already occupied by the first 2 queens, and there must be at least two squares attacked diagonally from the first 2 queens.
Thus, the maximum number of squares we can consider for the third queen is N−4. This pattern continues, resulting in an approximate time complexity of N!.

While it costs O(N^2) to build each valid solution, the amount of valid solutions S(N) does not grow nearly as fast as N!, so O(N!+S(N)∗N^2)=O(N!)
2
 )=O(N!)*/
public class NQueens {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        //we store the queens column position on the row in the queensPositions variable
        var queensPositions = new int[n];
        getSolution(0, queensPositions, result);
        return result;
    }

    private static void getSolution(int row, int[] queensPositions, List<List<String>> result) {
        //the solution is found when we reached the next row after final
        if (row == queensPositions.length) {
            result.add(renderSolution(queensPositions));
        }
        for (var cln = 0; cln < queensPositions.length; cln++) {
            if (!isUnderAttack(row, cln, queensPositions)) {
                queensPositions[row] = cln;
                getSolution(row + 1, queensPositions, result);
            }
        }
    }

    private static boolean isUnderAttack(int row, int column, int[] positions) {
        //we can skip the first row
        if (row == 0) {
            return false;
        }
        //We check all above rows if we have a queen that is placed on the same column
        //Genius observation: Two queens attack each other when columns' absolute distances are equal rows' absolute distances
        /*
            +---+-----+-----+----+----+----+
            | 0 | -1  |  -2 | -3 | -4 | -5 |
            +---+-----+-----+----+----+----+
            | 1 |   0 | -1  | -2 | -3 | -4 |
            +---+-----+-----+----+----+----+
            | 2 |   1 |   0 | -1 | -2 | -3 |
            +---+-----+-----+----+----+----+
            | 3 |   2 |   1 |  0 | -1 | -2 |
            +---+-----+-----+----+----+----+
            | 4 |   3 |   2 |  1 |  0 | -1 |
            +---+-----+-----+----+----+----+
            | 5 |   4 |   3 |  2 |  1 |  0 |
            +---+-----+-----+----+----+----+
        */
        for (var r = 0; r < row; r++) {
            var c = positions[r];
            if ((c == column) || ( Math.abs(column - c) == Math.abs(row - r))) {
                return true;
            }
        }
        return false;
    }

    private static ArrayList<String> renderSolution(int[] positions) {
        var solution = new ArrayList<String>();
        var sb = new StringBuilder(positions.length);
        for (var i = 0; i < positions.length; i++) {
            sb.setLength(0);
            for (var j = 0; j < positions.length; j++) {
                if (positions[i] == j) {
                    sb.append('Q');
                } else {
                    sb.append('.');
                }
            }
            solution.add(sb.toString());
        }
        return solution;
    }
}
