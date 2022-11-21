package Recursion;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class TotalNQueensTest {

    @Test
    public void totalNQueensTest() {
        var sut = new TotalNQueens();
        assertEquals(10, sut.totalNQueens(5));
    }
}
