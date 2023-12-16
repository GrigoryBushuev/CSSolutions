package Arrays;

import org.junit.jupiter.api.Test;

import static Sorting.InsertionSort.sort;
import static org.junit.jupiter.api.Assertions.*;

public class RemoveElementTest {

    @Test
    public void removeElementTest() {
        var sut = new RemoveElement();
        var nums = new int[] { 3, 2, 2, 3 };
        var size = sut.removeElement(nums, 3);
    }
}