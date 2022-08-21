package Arrays;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class SpiralOrderMatrixTest {

    @Test
    public void SpiralOrderMatrixTest() {
        var sut = new SpiralOrderMatrix();
        int[][] matrix = {
                { 1, 2, 3 },
                { 4, 5, 6 },
                { 7, 8, 9 }
        };
        var result = sut.spiralOrder(matrix);
        assertThat(result)
                .isNotEmpty()
                .isEqualTo(Arrays.asList(1, 2, 3, 6, 9, 8, 7, 4, 5 ));

        matrix = new int[][]{
                { 1, 2 },
                { 3, 4 },
                { 5, 6 },
                { 7, 8 }
        };
        result = sut.spiralOrder(matrix);
        assertThat(result)
                .isNotEmpty()
                .isEqualTo(Arrays.asList(1, 2, 4, 6, 8, 7, 5, 3 ));

        matrix = new int[][]{
                { 1, 2, 3, 4 },
                { 5, 6, 7, 8 },
                { 9, 10, 11, 12 }
        };
        result = sut.spiralOrder(matrix);
        assertThat(result)
                .isNotEmpty()
                .isEqualTo(Arrays.asList(1, 2, 3, 4, 8, 12, 11, 10, 9, 5, 6, 7 ));

        matrix = new int[][]{
                { 1, 2, 3 },
                { 4, 5, 6 },
                { 7, 8, 9 },
                { 10, 11, 12 }
        };
        result = sut.spiralOrder(matrix);
        assertThat(result)
                .isNotEmpty()
                .isEqualTo(Arrays.asList(1, 2, 3, 6, 9, 12, 11, 10, 7, 4, 5, 8 ));

        matrix = new int[][]{
                { 1, 2, 3 },
                { 4, 5, 6 },
                { 7, 8, 9 },
                { 10, 11, 12 },
                { 13, 14, 15 }
        };
        result = sut.spiralOrder(matrix);
        assertThat(result)
                .isNotEmpty()
                .isEqualTo(Arrays.asList(1, 2, 3, 6, 9, 12, 15, 14, 13, 10, 7, 4, 5, 8, 11 ));

        matrix = new int[][]{
                { 1 },
                { 2 },
                { 3 },
                { 4 }
        };
        result = sut.spiralOrder(matrix);
        assertThat(result)
                .isNotEmpty()
                .isEqualTo(Arrays.asList(1, 2, 3, 4));
    }
}
