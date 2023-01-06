package DynamicProgramming;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ProductOfArrayExceptSelfTest {
    @Test
    public void productExceptSelf_ReturnsExpectedResult() {
        int[] inputParams = { 1, 2, 3, 4 };
        var sut = new ProductOfArrayExceptSelf();
        var result = sut.productExceptSelf(inputParams);
        assertThat(result)
                .isNotEmpty()
                .hasSize(4)
                .containsExactly(24, 12, 8, 6);

        result = sut.productExceptSelf(new int[] { -1, 1, 0, -3, 3});
        assertThat(result)
                .isNotEmpty()
                .hasSize(5)
                .containsExactly(0, 0, 9, 0, 0);

        result = sut.productExceptSelf(new int[] { 0, 1, 2, 3});
        assertThat(result)
                .isNotEmpty()
                .hasSize(4)
                .containsExactly(6, 0, 0, 0);

        result = sut.productExceptSelf(new int[] { 0, 1, 2, 3, 0});
        assertThat(result)
                .isNotEmpty()
                .hasSize(5)
                .containsExactly(0, 0, 0, 0, 0);
    }
}