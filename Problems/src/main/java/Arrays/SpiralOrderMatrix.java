package Arrays;

import java.util.*;

public class SpiralOrderMatrix {
//    Given an m x n matrix, return all elements of the matrix in spiral order.
//    Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
//    Output: [1,2,3,6,9,8,7,4,5]

    public List<Integer> spiralOrder(int[][] matrix) {
        var result = new ArrayList<Integer>();
        //add boundaries check
        var top = 0;
        var left = 0;
        var right = matrix[top].length - 1;
        var bottom = matrix.length - 1;

        while (top < bottom && left < right) {
            for (var t = left; t <= right; t++) {
                result.add(matrix[top][t]);
            }
            top++;
            for (var r = top; r <= bottom;  r++) {
                result.add(matrix[r][right]);
            }
            right--;
            for (var b = right; b >= left; b--) {
                result.add(matrix[bottom][b]);
            }
            bottom--;
            for (var l = bottom; l >= top; l--) {
                result.add(matrix[l][left]);
            }
            left++;
        }

        if (matrix[0].length % 2 == 1 && top < bottom) {
            while (top <= bottom) {
                result.add(matrix[top++][left]);
            }
            return result;
        }

        if (matrix.length % 2 == 1 && left < right) {
            while (left <= right) {
                result.add(matrix[top][left++]);
            }
            return result;
        }
        if (matrix.length % 2 == 1 && matrix[0].length % 2 == 1) {
            result.add(matrix[top][left]);
        }
        return result;
    }
}
