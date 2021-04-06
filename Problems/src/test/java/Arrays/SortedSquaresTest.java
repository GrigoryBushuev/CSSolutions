package Arrays;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SortedSquaresTest {

    @Test
    public void sortedSquares_onAllNegative_ReturnsExpectedResult() {
        int[] inputParams = { -4, -3, -2, -1};
        var sut = new SortedSquares();
        var result = sut.sortedSquares(inputParams);
        assertThat(result)
                .isNotEmpty()
                .hasSize(4)
                .containsExactly(1, 4, 9, 16);
    }

    @Test
    public void sortedSquares_onAllNegativeAndZero_ReturnsExpectedResult() {
        int[] inputParams = { -1, 0};
        var sut = new SortedSquares();
        var result = sut.sortedSquares(inputParams);
        assertThat(result)
                .isNotEmpty()
                .hasSize(2)
                .containsExactly(0, 1);
    }

    @Test
    public void sortedSquares_onAllPositiveAndZero_ReturnsExpectedResult() {
        int[] inputParams = { 0, 1};
        var sut = new SortedSquares();
        var result = sut.sortedSquares(inputParams);
        assertThat(result)
                .isNotEmpty()
                .hasSize(2)
                .containsExactly(0, 1);
    }

    @Test
    public void sortedSquares_onAllPositive_ReturnsExpectedResult() {
        int[] inputParams = { 1, 2, 3, 4};
        var sut = new SortedSquares();
        var result = sut.sortedSquares(inputParams);
        assertThat(result)
                .isNotEmpty()
                .hasSize(4)
                .containsExactly(1, 4, 9, 16);
    }

    @Test
    public void sortedSquares_onNegativeAndZeroAndPositive_ReturnsExpectedResult() {
        int[] inputParams = {-2, -1, 0, 1, 2};
        var sut = new SortedSquares();
        var result = sut.sortedSquares(inputParams);
        assertThat(result)
                .isNotEmpty()
                .hasSize(5)
                .containsExactly(0, 1, 1, 4, 4);
    }
}
