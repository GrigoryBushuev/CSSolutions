package Sorting;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BottomUpMergeSortTest {

    @Test
    public void sortedSquares_onAllNegative_ReturnsExpectedResult() {
        Integer[] inputParams = { -6, 3, 1, 2, -4, 7, 5 };
        var sut = new BottomUpMergeSort();
        sut.sort(inputParams);
        assertThat(inputParams)
                .isNotEmpty()
                .hasSize(7)
                .containsExactly(-6, -4, 1, 2, 3, 5, 7);
    }
}