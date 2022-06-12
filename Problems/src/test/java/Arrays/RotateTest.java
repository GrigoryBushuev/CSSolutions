package Arrays;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
public class RotateTest {
    @Test
    public void rotateTest() {
        var sut = new Rotate();
        int[][] matrix = {
                { 1, 2, 3, 4 },
                { 5, 6, 7, 8 },
                { 9, 10, 11, 12 },
                { 13, 14, 15, 16 }
        };
        sut.rotateTransposeReflect(matrix);
        assertThat(matrix)
                .isNotEmpty()
                .hasSameDimensionsAs(matrix)
                .isDeepEqualTo(new int[][] { {13, 9, 5, 1}, {14, 10, 6, 2}, {15, 11, 7, 3}, {16, 12, 8, 4} });
    }

    @Test
    public void rotateTransposeReflectTest() {
        var sut = new Rotate();
        int[][] matrix = {
                { 1, 2, 3, 4 },
                { 5, 6, 7, 8 },
                { 9, 10, 11, 12 },
                { 13, 14, 15, 16 }
        };
        sut.rotateTransposeReflect(matrix);
        assertThat(matrix)
                .isNotEmpty()
                .hasSameDimensionsAs(matrix)
                .isDeepEqualTo(new int[][] { {13, 9, 5, 1}, {14, 10, 6, 2}, {15, 11, 7, 3}, {16, 12, 8, 4} });
    }
}
