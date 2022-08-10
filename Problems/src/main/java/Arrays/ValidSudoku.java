package Arrays;
import java.util.HashSet;

public class ValidSudoku {
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

    public boolean isValidSudoku(char[][] board) {
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
