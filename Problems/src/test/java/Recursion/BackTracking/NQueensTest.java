package Recursion.BackTracking;
import Recursion.NQueens;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class NQueensTest {

    @Test
    public void totalNQueensTest() {
        var sut = new NQueens();
        //assertEquals(2, sut.totalNQueens(4));
        assertEquals(10, sut.totalNQueens(5));

    }
}
