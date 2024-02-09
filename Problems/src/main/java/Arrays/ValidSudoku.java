package Arrays;
import java.util.HashSet;

/*
36. Valid Sudoku
Determine if a 9 x 9 Sudoku board is valid. Only the filled cells need to be validated according to the following rules:

Each row must contain the digits 1-9 without repetition.
Each column must contain the digits 1-9 without repetition.
Each of the nine 3 x 3 sub-boxes of the grid must contain the digits 1-9 without repetition.
Note:

A Sudoku board (partially filled) could be valid but is not necessarily solvable.
Only the filled cells need to be validated according to the mentioned rules.


Example 1:
Input: board =
[["5","3",".",".","7",".",".",".","."]
,["6",".",".","1","9","5",".",".","."]
,[".","9","8",".",".",".",".","6","."]
,["8",".",".",".","6",".",".",".","3"]
,["4",".",".","8",".","3",".",".","1"]
,["7",".",".",".","2",".",".",".","6"]
,[".","6",".",".",".",".","2","8","."]
,[".",".",".","4","1","9",".",".","5"]
,[".",".",".",".","8",".",".","7","9"]]
Output: true

Example 2:
Input: board =
[["8","3",".",".","7",".",".",".","."]
,["6",".",".","1","9","5",".",".","."]
,[".","9","8",".",".",".",".","6","."]
,["8",".",".",".","6",".",".",".","3"]
,["4",".",".","8",".","3",".",".","1"]
,["7",".",".",".","2",".",".",".","6"]
,[".","6",".",".",".",".","2","8","."]
,[".",".",".","4","1","9",".",".","5"]
,[".",".",".",".","8",".",".","7","9"]]
Output: false
Explanation: Same as Example 1, except with the 5 in the top left corner being modified to 8. Since there are two 8's in the top left 3x3 sub-box, it is invalid.

Constraints:
board.length == 9
board[i].length == 9
board[i][j] is a digit 1-9 or '.'.
*/
public class ValidSudoku {
    private static int setBit(int mask, int val) {
        return mask | 1 << val;
    }

    private static boolean isSet(int mask, int val) {
        return (mask & (1 << val)) != 0;
    }

    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            int row = 0, column = 0, sub = 0;
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] != '.') {
                    int val = board[i][j] - '0';
                    if (isSet(row, val)) {
                        return false;
                    }
                    row = setBit(row, val);
                }
                if (board[j][i] != '.') {
                    int val = board[j][i] - '0';
                    if (isSet(column, val)) {
                        return false;
                    }
                    column = setBit(column, val);
                }
                int startRow = (i/3) * 3;
                int startColumn = (i % 3) * 3;
                int subRow = startRow + (j / 3);
                int subColumn = startColumn + (j % 3);
                if (board[subRow][subColumn] != '.') {
                    int val = board[subRow][subColumn] - '0';
                    if (isSet(sub, val)) {
                        return false;
                    }
                    sub = setBit(sub, val);
                }
            }
        }
        return true;
    }

    private boolean check(HashSet<Character> set, char[][] board, int row, int column) {
        if (board[row][column] == '.') {
            return true;
        }
        if (set.contains(board[row][column])) {
            return false;
        }
        set.add(board[row][column]);
        return true;
    }

    public boolean isValidSudoku2(char[][] board) {
        for (var i = 0; i < board.length; i++) {
            var rowSet = new HashSet<Character>();
            var columnSet = new HashSet<Character>();
            var subSet = new HashSet<Character>();
            for (var j = 0; j < board.length; j++) {
                if (!check(rowSet, board, i, j)) {
                    return false;
                }
                if (!check(columnSet, board, j, i)) {
                    return false;
                }
                var subsetInitRow = (i / 3) * 3;
                var subsetInitColumn = (i % 3) * 3;
                var subsetRow = subsetInitRow + (j / 3);
                var subsetColumn = subsetInitColumn + (j % 3);
                if (!check(subSet, board, subsetRow, subsetColumn)) {
                    return false;
                }
            }
        }
        return true;
    }
}
