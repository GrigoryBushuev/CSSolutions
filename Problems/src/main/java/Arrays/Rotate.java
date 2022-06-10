package Arrays;

public class Rotate {
    private static void swap(int[][] matrix, int i, int j, int k, int l) {
        var temp = matrix[i][j];
        matrix[i][j] = matrix[k][l];
        matrix[k][l] = temp;
    }

    public void rotate(int[][] matrix) {
        var matrixSize = matrix.length - 1;
        var layerSize = matrix.length / 2;

        for (var layer = 0; layer < layerSize; layer++) {
            for (var i = layer; i < matrixSize - layer; i++) {
                var topLeft = matrix[layer][i];
                var topRight = matrix[i][matrixSize-layer];
                var bottomLeft = matrix[matrixSize - i][layer];
                var bottomRight = matrix[matrixSize - layer][matrixSize - i];
                matrix[i][matrixSize-layer] = topLeft;//tr
                matrix[matrixSize - layer][matrixSize - i] = topRight;//br
                matrix[matrixSize - i][layer] = bottomRight;//bl
                matrix[layer][i] = bottomLeft;
            }
        }
    }
}
