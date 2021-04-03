package Arrays;

import org.junit.jupiter.api.Test;

import static Arrays.EvenNumberOfDigitsFinder.getNumberOfDigits;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class EvenNumberOfDigitsFinderTest {
    @Test
    public void getNumberOfDigitsTest() {
        assertEquals(10, getNumberOfDigits(Integer.MAX_VALUE));
        assertEquals(10, getNumberOfDigits(1_000_000_000));
        assertEquals(10, getNumberOfDigits(1_000_000_001));
        assertEquals(9, getNumberOfDigits(100_000_000));
        assertEquals(9, getNumberOfDigits(100_000_001));
        assertEquals(8, getNumberOfDigits(10_000_000));
        assertEquals(8, getNumberOfDigits(10_000_001));
        assertEquals(7, getNumberOfDigits(1_000_000));
        assertEquals(7, getNumberOfDigits(1_000_001));
        assertEquals(6, getNumberOfDigits(100_000));
        assertEquals(6, getNumberOfDigits(100_001));
        assertEquals(5, getNumberOfDigits(10_000));
        assertEquals(5, getNumberOfDigits(10_001));
        assertEquals(4, getNumberOfDigits(1_000));
        assertEquals(4, getNumberOfDigits(1_001));
        assertEquals(3, getNumberOfDigits(100));
        assertEquals(3, getNumberOfDigits(101));
        assertEquals(2, getNumberOfDigits(10));
        assertEquals(2, getNumberOfDigits(11));
        assertEquals(1, getNumberOfDigits(0));
        assertEquals(1, getNumberOfDigits(1));
    }


}
