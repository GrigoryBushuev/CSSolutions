package Recursion.Subproblems;

import java.util.HashMap;

/*
221. Maximal Square
Given an m x n binary matrix filled with 0's and 1's, find the largest square containing only 1's and return its area.

 Example:

Input: matrix = [["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"],["1","0","0","1","0"]]
Output: 4
Example 2:

Input: matrix = [["0","1"],["1","0"]]
Output: 1
Example 3:

Input: matrix = [["0"]]
Output: 0

Constraints:
m == matrix.length
n == matrix[i].length
1 <= m, n <= 300
matrix[i][j] is '0' or '1'.

Where are the subproblems?
Look at subproblems geometrically
*/
public class MaximalSquareRecursive {
    public int maximalSquare(char[][] matrix) {
        int width = matrix[0].length;
        int height = matrix.length;
        if (width == height && width == 1) {
            return matrix[0][0] - '0';
        }
        HashMap<String, Integer> cache = new HashMap<>();
        if (width == height) {
            return getMaxSquareSize(matrix, 0, 0, width, cache);
        }
        int result = 0;
        if (width > height) {
             for (int i = 0; i + height <= matrix[0].length; i++) {
                 result = Math.max(result, getMaxSquareSize(matrix, 0, i, height, cache));
                 if (result == height * height) {
                     return result;
                 }
             }
        } else {
            for (int i = 0; i + width <= matrix.length; i++) {
                result = Math.max(result, getMaxSquareSize(matrix, i, 0, width, cache));
                if (result == width * width) {
                    return result;
                }
            }
        }
        return result;
    }

    private int getMaxSquareSize(char[][] matrix, int i, int j, int size, HashMap<String, Integer> cache) {
        if (size == 1) {
            return matrix[i][j] - '0';
        }
        String key = String.format("{%d}{%d}{%d}", i, j, size);
        if (cache.containsKey(key)){
            return cache.get(key);
        }
        int nextSquareSize = size - 1;
        int topLeftSize, topRightSize, bottomLeftSize, bottomRightSize = 0;
        topLeftSize = getMaxSquareSize(matrix, i, j, nextSquareSize, cache);
        topRightSize = getMaxSquareSize(matrix, i, j + 1, nextSquareSize, cache);
        bottomLeftSize = getMaxSquareSize(matrix, i + 1, j, nextSquareSize, cache);
        bottomRightSize = getMaxSquareSize(matrix, i + 1, j + 1, nextSquareSize, cache);

        int result = 0;
        var hasAllQuadsHaveOnes = (topLeftSize == topRightSize) &&
                                    (topRightSize == bottomLeftSize) &&
                                    (bottomLeftSize == bottomRightSize) &&
                                    bottomRightSize == nextSquareSize * nextSquareSize;
        if (hasAllQuadsHaveOnes) {
            result = size * size;
        }
        else {
            result = Math.max(Math.max(topLeftSize, topRightSize), Math.max(bottomLeftSize, bottomRightSize));
        }
        cache.put(key, result);
        return result;
    }
}
