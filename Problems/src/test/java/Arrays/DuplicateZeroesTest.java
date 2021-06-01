package Arrays;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class DuplicateZeroesTest {

    @Test
    public void duplicateZeroes_ReturnsExpectedResult() {
        int[] inputParams = { 1, 0, 2, 3, 0, 4, 5, 0 };
        var sut = new DuplicateZeroes();
        sut.duplicateZeros(inputParams);
        assertThat(inputParams)
                .isNotEmpty()
                .hasSize(8)
                .containsExactly(1, 0, 0, 2, 3, 0, 0, 4);
    }
}
