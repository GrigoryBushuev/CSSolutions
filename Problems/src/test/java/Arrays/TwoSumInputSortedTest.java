package Arrays;

import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

public class TwoSumInputSortedTest {

    @Test
    public void TwoSumTest() {
        var input = new int[]{ 2, 3, 4 };
        var sut = new TwoSumInputSorted();
        var result = sut.twoSum(input, 6);
        assertThat(result)
                .isNotEmpty()
                .hasSize(2)
                .contains(1, 3);
        input = new int[]{ 3,3 };
        result = sut.twoSum(input, 6);
        assertThat(result)
                .isNotEmpty()
                .hasSize(2)
                .contains(1, 2);

        input = new int[]{ 2, 7, 11, 15 };
        result = sut.twoSum(input, 9);
        assertThat(result)
                .isNotEmpty()
                .hasSize(2)
                .contains(1, 2);
    }
}
