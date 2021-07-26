package BinarySearch;

class MatrixSearch {
    public boolean hasTarget(int[][] matrix, int startIndex, int target) {
        var lo = startIndex;
        var hi = matrix[0].length - 1;

        if (startIndex >  hi) {
            return false;
        }

        while (lo <= hi) {
            var current = lo + ((hi - lo) / 2);
            if (matrix[startIndex][current] == target) {
                return true;
            } else if (matrix[startIndex][current] > target) {
                hi = current - 1;
            } else {
                lo = current + 1;
            }
        }

        lo = startIndex;
        hi = matrix.length - 1;
        while (lo <= hi) {
            var current = lo + ((hi - lo) / 2);
            if (matrix[current][startIndex] == target) {
                return true;
            } else if (matrix[current][startIndex] > target) {
                hi = current - 1;
            } else {
                lo = current + 1;
            }
        }
        return false;
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        //assert null
        var m = matrix[0].length;
        var n = matrix.length;
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

    public static boolean quickSearchMatrix(int[][] matrix, int target) {
        //assert null
        var m = matrix[0].length;
        var n = matrix.length;
        if (m == 1 && n == 1) {
            return matrix[0][0] == target;
        }

        var colIndex = 0;
        var rowIndex = n - 1; //3

        while (rowIndex >= 0 && colIndex < m) {
            if (matrix[rowIndex][colIndex] == target) {
                return true;
            }
            if (matrix[rowIndex][colIndex] > target) {
                rowIndex--;
            }
            if (rowIndex >= 0 && matrix[rowIndex][colIndex] < target) {
                colIndex++;
            }
        }
        return false;
    }
}