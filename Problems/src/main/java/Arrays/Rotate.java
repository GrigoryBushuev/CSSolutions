package Arrays;

public class Rotate {
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

    private static void swap(int[][] matrix, int i, int j, int k, int l) {
        var temp = matrix[i][j];
        matrix[i][j] = matrix[k][l];
        matrix[k][l] = temp;
    }

    public void rotateTransposeReflect(int[][] matrix) {
        //transpose
        for (var i = 0; i < matrix.length; i++) {
            for (var j = i; j < matrix.length; j++) {
                swap(matrix, i, j, j, i);
            }
        }
        //Reflect
        for (var i = 0; i < matrix.length / 2; i++) {
            for (var j = 0; j < matrix.length; j++) {
                swap(matrix, j, i, j,matrix.length - 1 - i);
            }
        }
    }
}
