package Recursion.Permutations;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class NDigitSumTest {
    @Test
    public void getNDigitSumTest() {
        var sut = new NDigitSum();
        var result = sut.getNDigitSum(2, 3);
        assertThat(result)
                .isNotEmpty()
                .hasSize(3)
                .contains(12, 21, 30);

        result = sut.getNDigitSum(2, 5);
        assertThat(result)
                .isNotEmpty()
                .hasSize(5)
                .contains(14, 23, 32, 41, 50);
    }
}