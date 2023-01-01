package DynamicProgramming;

import java.util.*;

/*
120. Triangle
Given a triangle array, return the minimum path sum from top to bottom.
For each step, you may move to an adjacent number of the row below.
More formally, if you are on index i on the current row, you may move to either index i or index i + 1 on the next row.

Example 1:
Input: triangle = [[2],[3,4],[6,5,7],[4,1,8,3]]
Output: 11
Explanation: The triangle looks like:
   2
  3 4
 6 5 7
4 1 8 3
The minimum path sum from top to bottom is 2 + 3 + 5 + 1 = 11 (underlined above).

Example 2:
Input: triangle = [[-10]]
Output: -10

Constraints:

1 <= triangle.length <= 200
triangle[0].length == 1
triangle[i].length == triangle[i - 1].length + 1
-104 <= triangle[i][j] <= 104

Follow up: Could you do this using only O(n) extra space, where n is the total number of rows in the triangle?*/
public class Triangle {
    public static int getMinimumTotalTopDown(List<List<Integer>> triangle) {
        if (triangle.size() == 1) {
            return triangle.get(0).get(0);
        }
        var bottomIndex = triangle.size();
        var cache = new Integer[bottomIndex][triangle.get(bottomIndex - 1).size()];
        return getMinimumTotalTopDown(triangle, 0, 0, cache);
    }

    public static int getMinimumTotalBottomUpInPlace(List<List<Integer>> trianlge) {
        for (var row = 1; row < trianlge.size(); row++) {
            var currentRowSize = trianlge.get(row).size();
            for (var clmn = 0; clmn < currentRowSize; clmn++) {
                var prevMin = Integer.MAX_VALUE;
                var prevRow = trianlge.get(row - 1);
                if (clmn > 0) {
                    var topLeft = prevRow.get(clmn - 1);
                    prevMin = clmn < currentRowSize - 1 ? Math.min(topLeft, prevRow.get(clmn)) : topLeft;
                } else {
                    prevMin = prevRow.get(0);
                }
                //Set new values as currentValue + min on the prev row
                trianlge.get(row).set(clmn, trianlge.get(row).get(clmn) + prevMin);
            }
        }
        //The result is total min of the last precalculated row
        return Collections.min(trianlge.get(trianlge.size() - 1));
    }

    public static int getMinimumTotalBottomUp(List<List<Integer>> triangle) {
        var cache = new int[triangle.size()];
        Arrays.fill(cache, Integer.MAX_VALUE);
        cache[0] = triangle.get(0).get(0);

        for (var row = 1; row < triangle.size(); row++) {
            var currentRowSize = triangle.get(row).size();
            var prevMin = Integer.MIN_VALUE;
            for (var clmn = 0; clmn < currentRowSize; clmn++) {
                if (clmn > 0) {
                    if (clmn < currentRowSize - 1) {
                        var min = Math.min(prevMin, cache[clmn]);
                        prevMin = cache[clmn];
                        cache[clmn] = triangle.get(row).get(clmn) + min;
                    } else {
                        cache[clmn] = triangle.get(row).get(clmn) + prevMin;
                    }
                } else {
                    prevMin = cache[0];
                    cache[0] = triangle.get(row).get(clmn) + cache[0];
                }
            }
        }
        //The result is total min of the last precalculated row
        return Arrays.stream(cache).min().getAsInt();
    }

    private static int getMinimumTotalTopDown(List<List<Integer>> triangle, int rowIndex, int columnIndex, Integer[][] cache) {
        var cachedValue = cache[rowIndex][columnIndex];
        if (cachedValue != null) {
            return cachedValue;
        }
        var curRow = triangle.get(rowIndex);
        var currentTotal = curRow.get(columnIndex);
        if (rowIndex == triangle.size() - 1) {
            return curRow.get(columnIndex);
        }
        var left = getMinimumTotalTopDown(triangle, rowIndex + 1, columnIndex, cache);
        var right = getMinimumTotalTopDown(triangle, rowIndex + 1, columnIndex + 1, cache);
        var result = currentTotal + Math.min(left, right);
        cache[rowIndex][columnIndex] = result;
        return result;
    }
}
