package BinarySearch;

import Arrays.TwoSumInputSorted;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BinarySearchTest {

    @Test
    public void BinarySearchTest() {
        var sut = new BinarySearch();
        var input = new int[] { 0, 1, 1, 2, 3, 4, 5, 7, 7, 8, 9 };
        var result = sut.findIndex(input, 5, Optional.empty());
        assertEquals(6, result);
        result = sut.findIndex(input, 6, Optional.empty());
        assertEquals(-1, result);
        result = sut.findIndex(input, 0, Optional.empty());
        assertEquals(0, result);
        result = sut.findIndex(input, 9, Optional.empty());
        assertEquals(10, result);
        result = sut.findIndex(input, 1, Optional.of(2));
        assertEquals(1, result);
        result = sut.findIndex(input, 1, Optional.of(2));
        assertEquals(1, result);
    }
}
