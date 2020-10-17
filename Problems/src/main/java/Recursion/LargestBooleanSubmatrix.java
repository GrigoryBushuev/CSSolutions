package Recursion;

public class LargestBooleanSubmatrix {

    public static int squareSubmatrix(boolean[][] arr) {
        return squareSubmatrix(arr, 0, 0);
    }

    private static int getCurrentSize(boolean[][] arr, int i, int j) {
        if (!arr[i][j]) {
            return 0;
        }
        var result = 0;
        for (var size = 1; size + i < arr.length && size + j < arr[i].length; size++) {
            var needBreak = false;
            for (int x = i; x < i + size + 1; x++) {
                if (!arr[x][j + size]) {
                    needBreak = true;
                    break;
                }
            }
            if (needBreak) {
                break;
            }
            for (int y = j; y < j + size + 1; y++) {
                if (!arr[i + size][y]) {
                    needBreak = true;
                    break;
                }
            }
            if (needBreak) {
                break;
            }
            result = size + 1;
        }
        return result;
    }

    private static int squareSubmatrix(boolean[][] arr, int i, int j) {
        if (i >= arr.length || j >= arr[i].length) {
            return 0;
        }
        var size = getCurrentSize(arr, i, j);
        size = Math.max(size, Math.max(squareSubmatrix(arr, i + 1, j), squareSubmatrix(arr, i, j + 1)));
        return size;
    }

    public static void main(String[] args) {
        System.out.println(squareSubmatrix(new boolean[][]{
                        { true, true },
                        { true, true }
                })
        );
        System.out.println(squareSubmatrix(new boolean[][]{
                        { true, true, true },
                        { true, false, true },
                        { true, true, true }
                })
        );
        System.out.println(squareSubmatrix(new boolean[][]{
                        { false, true, false },
                        { true, true, true },
                        { false, true, true }
                })
        );
        System.out.println(squareSubmatrix(new boolean[][]{
                        { true, true, true },
                        { true, true, true },
                        { true, true, true }
                })
        );
        System.out.println(squareSubmatrix(new boolean[][]{
                                                            { false, true, false, false },
                                                            { true, true, true, true },
                                                            { false, true, true, false }
                                                        }
                                        )
        );
    }
}
