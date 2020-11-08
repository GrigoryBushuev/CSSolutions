package Recursion;

import java.util.*;

public class PascalTriangle {

    public static List<Integer> getRow(int rowIndex) {
        if (rowIndex == 0) {
            return Arrays.asList(1);
        }
        var result = new ArrayList<Integer>();
        var start = 0;
        for (var val : getRow(rowIndex - 1)) {
            result.add(start + val);
            start = val;
        }
        result.add(1);
        return result;
    }

    public static void main(String[] args) {
        for (int i : getRow(4)) {
            System.out.print(i);
        }
    }

    //1
    //1 1
    //1 2 1
    //1 3 3 1
    //1 4 6 4 1
    //1 5 10 10 5 1
}
