package Recursion.Subproblems;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MaximalSquareRecursiveTest {

    @Test
    public void maximalSquareTest() {
        var sut = new MaximalSquareRecursive();
//        var result = sut.maximalSquare(new char[][] { new char[]{'0'} });
//        Assert.assertEquals(0, result);
//
//        //[["0","1"],["1","0"]]
//        result = sut.maximalSquare(new char[][] { new char[]{'0', '1'}, new char[] {'1', '0'} });
//        Assert.assertEquals(1, result);

//        Input: matrix = [["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"],["1","0","0","1","0"]]
//        Output: 4

        var result = sut.maximalSquare(new char[][]
                                                {
                                                        new char[] {'1', '0', '1', '0', '0'},
                                                        new char[] {'1', '0', '1', '1', '1'},
                                                        new char[] {'1', '1', '1', '1', '1'},
                                                        new char[] {'1', '0', '0', '1', '0'}
                                                }
        );
        Assert.assertEquals(4, result);
    }
}