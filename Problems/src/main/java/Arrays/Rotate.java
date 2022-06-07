package Arrays;

public class Rotate {
    private static void swap(int[][] matrix, int i, int j, int k, int l) {
        var temp = matrix[i][j];
        matrix[i][j] = matrix[k][l];
        matrix[k][l] = temp;
    }

    public void rotate(int[][] matrix) {
        var start = 0;
        var end = matrix.length - 1;
        var size = matrix.length / 2;

        for (var cur = 0; cur < size; cur++) {
            for (var i = start + cur; i < end - cur; i++) {
                swap(matrix, cur, i,  i,end - cur);
                swap(matrix, cur, i, end - i, cur);
                swap(matrix, end - i, cur, end - cur, end - i);
            }
        }
    }
}
