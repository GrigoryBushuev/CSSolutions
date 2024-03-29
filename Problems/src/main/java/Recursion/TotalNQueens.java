package Recursion;

/*
    The n-queens puzzle is the problem of placing n queens on an n x n chessboard such that no two queens attack each other.
    Given an integer n, return the number of distinct solutions to the n-queens puzzle.

    Example 1:
    Input: n = 4
    Output: 2
    Explanation: There are two distinct solutions to the 4-queens puzzle as shown.

    Example 2:
    Input: n = 1
    Output: 1

    Constraints:
    1 <= n <= 9
*/
public class TotalNQueens {

    private int[] colPositions;
    private int size;
    private int total;

    public int totalNQueens(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2 || n == 3) {
            return 0;
        }
        this.size = n;
        getNumberOfPositions(n);
        return this.total;
    }

    /*
    * As we don't put a queen into the same row we keep track columns in the array so
    * each index represents a row and its value represents a column
    * A queen is under attack when there are the same values in the array or an absolute value of positions in columns is equal to an absolute value of positions in rows
    * The idea is back to back swe
     */
    private boolean isUnderAttack(int row, int col) {
        for (var i = 0; i < row; i++) {
            if (this.colPositions[i] == col || Math.abs(col - this.colPositions[i]) == Math.abs(row - i)) {
                return true;
            }
        }
        return false;
    }

    private void getNumberOfPositions(int n) {
        this.colPositions = new int[n];
        makeAChoice(0);
    }

    private void makeAChoice(int currentRow) {
        for (var col = 0; col < this.size; col++) {
            if (!isUnderAttack(currentRow, col)) {
                this.colPositions[currentRow] = col;
                if (currentRow == this.size - 1) {
                    total++;
                    continue;
                }
                makeAChoice(currentRow + 1);
            }
        }
    }
}
