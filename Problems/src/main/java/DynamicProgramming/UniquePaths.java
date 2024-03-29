package DynamicProgramming;

/*
There is a robot on an m x n grid. The robot is initially located at the top-left corner (i.e., grid[0][0]).
The robot tries to move to the bottom-right corner (i.e., grid[m - 1][n - 1]). The robot can only move either down or right at any point in time.
Given the two integers m and n, return the number of possible unique paths that the robot can take to reach the bottom-right corner.

The test cases are generated so that the answer will be less than or equal to 2 * 109.

Example 1:
Input: m = 3, n = 7
Output: 28

Example 2:
Input: m = 3, n = 2
Output: 3
Explanation: From the top-left corner, there are a total of 3 ways to reach the bottom-right corner:
1. Right -> Down -> Down
2. Down -> Down -> Right
3. Down -> Right -> Down


Constraints:
1 <= m, n <= 100
*/
public class UniquePaths {

    public int uniquePaths(int m, int n) {
        int[][] cache = new int[m][n];
        //return getNumberOfUniquePathsRecursive(0, 0, m - 1, n - 1, cache);
        return getNumberOfUniquePathsIterative(m, n, cache);
    }

    private static int getNumberOfUniquePathsRecursive(int rowIndex, int columnIndex, int totalRowsIndex, int totalColumnsIndex, int[][] cache) {
        if (rowIndex == totalRowsIndex && columnIndex == totalColumnsIndex) {
            return 1;
        }
        if (cache[rowIndex][columnIndex] != 0) {
            return cache[rowIndex][columnIndex];
        }
        int downPaths = 0;
        if (rowIndex < totalRowsIndex) {
            downPaths = getNumberOfUniquePathsRecursive(rowIndex + 1, columnIndex, totalRowsIndex, totalColumnsIndex, cache);
        }
        int rightPaths = 0;
        if (columnIndex < totalColumnsIndex) {
            rightPaths = getNumberOfUniquePathsRecursive(rowIndex, columnIndex + 1, totalRowsIndex, totalColumnsIndex, cache);
        }
        var result = downPaths + rightPaths;
        cache[rowIndex][columnIndex] = result;
        return result;
    }
    /*
        Total unique paths to any given cell:
         -----------
        | 1 | 1 | 1 |
        | 1 | 2 | 3 |
        | 1 | 3 | 6 |
         -----------
    */
    private static int getNumberOfUniquePathsIterative(int rows, int columns, int[][] cache) {
        for (var i = 0; i < rows; i++) {
            cache[i][0] = 1;
        }
        for (var j = 0; j < columns; j++) {
            cache[0][j] = 1;
        }
        for (var row = 1; row < rows; row++) {
            for (var column = 1; column < columns; column++) {
                cache[row][column] = cache[row - 1][column] + cache[row][column - 1];
            }
        }
        return cache[rows - 1][columns - 1];
    }
}
