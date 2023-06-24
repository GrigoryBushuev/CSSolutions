package LinkedLists;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DuplicateNumberTest {

    @Test
    void findDuplicateTest() {
        var sut = new DuplicateNumber();
        assertEquals(2, sut.findDuplicate(new int[] { 1, 3, 4, 2, 5, 2 }));
        assertEquals(2, sut.findDuplicate(new int[] { 1, 3, 4, 2, 2 }));
        assertEquals(3, sut.findDuplicate(new int[] { 3, 1, 3, 4, 2 }));

        assertEquals(2, sut.findDuplicateWithNegativeMarking(new int[] { 1, 3, 4, 2, 5, 2 }));
        assertEquals(2, sut.findDuplicateWithNegativeMarking(new int[] { 1, 3, 4, 2, 2 }));
        assertEquals(3, sut.findDuplicateWithNegativeMarking(new int[] { 3, 1, 3, 4, 2 }));
    }
}