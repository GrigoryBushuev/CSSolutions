package BinarySearch;

class Solution {
    public boolean hasTarget(int[][] matrix, int startIndex, int target) {
        var lo = startIndex;
        var hi = matrix.length - 1;

        while (lo < hi) {
            var current = lo + ((hi - lo) / 2);
            if (matrix[startIndex][current] == target) {
                return true;
            } else if (matrix[startIndex][current] > target) {
                hi = current;
            } else {
                lo = current;
            }
        }

        lo = startIndex;
        hi = matrix[startIndex].length - 1;
        while (lo < hi) {
            var current = lo + ((hi - lo) / 2);
            if (matrix[current][startIndex] == target) {
                return true;
            } else if (matrix[current][startIndex] > target) {
                hi = current;
            } else {
                lo = current;
            }
        }
        return false;
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        //assert null
        var m = matrix.length;
        var n = matrix[0].length;
        if (m == 1 && n == 1) {
            return matrix[0][0] == target;
        }
        for (var i = 0; i < n; i++) {
            if (hasTarget(matrix, i, target)) {
                return true;
            }
        }
        return false;
    }
}