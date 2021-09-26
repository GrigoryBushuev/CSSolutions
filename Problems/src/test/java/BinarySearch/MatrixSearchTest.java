package BinarySearch;

import org.junit.Assert;
import org.junit.Test;

public class MatrixSearchTest {

    @Test
    public void hasTarget_Test() {
        //Arrange
        var matrixSearch = new MatrixSearch();

        int[][] matrix3 = {
                {0, 1, 2},
                {3, 4, 5},
                {6, 7, 8}
        };
        Assert.assertTrue(matrixSearch.searchMatrix(matrix3, 7));
        int[][] matrix2 = {
                {1, 2},
                {4, 5},
        };
        Assert.assertTrue(matrixSearch.searchMatrix(matrix2, 5));
        int[][] matrix = {
                {1, 1}
        };
        Assert.assertTrue(matrixSearch.searchMatrix(matrix, 1));
    }

    @Test
    public void hasTarget_returnsFalse() {
        //Arrange
        var matrixSearch = new MatrixSearch();

        int[][] matrix3 = {
                {0, 1, 2},
                {3, 4, 5},
                {6, 7, 8}
        };
        Assert.assertFalse(matrixSearch.searchMatrix(matrix3, -3));

        int[][] matrix2 = {
                {1, 2},
                {4, 5},
        };
        Assert.assertFalse(matrixSearch.searchMatrix(matrix2, -2));

        int[][] matrixH1 = {
                { -1, -1 }
        };
        Assert.assertFalse(matrixSearch.searchMatrix(matrixH1, -2));

        int[][] matrixV1 = {
                { -1 },
                { -1}
        };
        Assert.assertFalse(matrixSearch.searchMatrix(matrixV1, -2));
    }
}
