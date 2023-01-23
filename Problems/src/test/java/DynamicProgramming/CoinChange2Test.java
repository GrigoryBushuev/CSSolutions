package DynamicProgramming;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CoinChange2Test {

    @Test
    public void getCoinChange_returnsExpectedResult() {
        var sut = new CoinChange2();
        var actualResult = sut.change(5, new int[] { 1, 2, 5 });
        assertEquals(4, actualResult);
        actualResult = sut.change(3, new int[] { 2 });
        assertEquals(0, actualResult);
        actualResult = sut.change(10, new int[] { 10 });
        assertEquals(1, actualResult);
    }
}