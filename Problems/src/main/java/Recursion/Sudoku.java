package Recursion;

public class Sudoku {
    private static final char EMPTY_CELL = '.';

    public void solveSudoku(char[][] board) {
        solve(board, 0, 0);
    }

    private static boolean isValid(char[][] board, int row, int column, char value) {
        for (var i = 0; i < 9; i++) {
            if (board[row][i] == value) {
                return false;
            }
        }

        for (var j = 0; j < 9; j++) {
            if (board[j][column] == value) {
                return false;
            }
        }

        var startRow = (row / 3) * 3;
        var startColumn = (column / 3) * 3;

        for (var i = startRow; i < startRow + 3; i++) {
            for (var j = startColumn; j < startColumn + 3; j++) {
                if (board[i][j] == value) {
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean solve(char[][] board, int row, int column) {
        if (row == board.length && column == 0) {
            return true;
        }
        if (column == board[0].length) {
            return solve(board, row + 1, 0);
        }
        if (board[row][column] != EMPTY_CELL) {
            return solve(board, row, column + 1);
        }
        for (var value = 1; value <= 9; value++) {
            var charVal = Character.forDigit(value, 10);
            if (isValid(board, row, column, charVal)) {
                board[row][column] = charVal;
                if (solve(board, row, column + 1)) {
                    return true;
                }
            }
        }
        board[row][column] = EMPTY_CELL;
        return false;
    }
}


