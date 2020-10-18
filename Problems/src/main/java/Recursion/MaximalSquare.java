package Recursion;

public class MaximalSquare {

    public static int getMaxSquare(char[][] matrix) {
        var result = 0;

        for (var i = 0; i < matrix.length; i++) {
            for (var j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] != '1') {
                    continue;
                }
                if (result == 0) {
                    result = 1;
                }
                for (var size = 1; size + i < matrix.length && size + j < matrix[i].length; size++) {
                    var needBreak = false;
                    for (int x = i; x < i + size + 1; x++) {
                        if (matrix[x][j + size] != '1') {
                            needBreak = true;
                            break;
                        }
                    }
                    if (needBreak) {
                        break;
                    }
                    for (int y = j; y < j + size + 1; y++) {
                        if (matrix[i + size][y] != '1') {
                            needBreak = true;
                            break;
                        }
                    }
                    if (needBreak) {
                        break;
                    }
                    result = Math.max(result, size + 1);
                }
            }
        }
        return result * result;
    }

    public static void main(String[] args) {
        System.out.println(getMaxSquare(new char[][]{
                        { '1' }
                })
        );
        System.out.println(getMaxSquare(new char[][]{
                        { '1', '0', '1', '0', '0' },
                        { '1', '0', '1', '1', '1' },
                        { '1', '1', '1', '1', '1' },
                        { '1', '0', '0', '1', '0' }
                })
        );
//        System.out.println(squareSubmatrix(new boolean[][]{
//                        { false, true, false },
//                        { true, true, true },
//                        { false, true, true }
//                })
//        );
        System.out.println(getMaxSquare(new char[][]{
                        { '1', '1', '1' },
                        { '1', '1', '1' },
                        { '1', '1', '1' }
                })
        );
//        System.out.println(squareSubmatrix(new boolean[][]{
//                                                            { false, true, false, false },
//                                                            { true, true, true, true },
//                                                            { false, true, true, false }
//                                                        }
//                                        )
//        );
    }
}
