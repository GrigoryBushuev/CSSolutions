package Recursion.Permutations;

import org.junit.Test;
import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;


public class PermutationsOfLengthTest {
    @Test
    public void getPermutationsOfLengthTest() {
        var sut = new PermutationsOfLength();
        var result = sut.getPermutationsOfLength(new Integer[] { 1, 2, 3, 4 }, 2);
        assertThat(result)
                .isNotEmpty()
                .hasSize(12)
                .contains(Arrays.asList(1, 2), Arrays.asList(1, 3), Arrays.asList(1, 4),
                        Arrays.asList(2, 1), Arrays.asList(2, 3), Arrays.asList(2, 4),
                        Arrays.asList(3, 1), Arrays.asList(3, 2), Arrays.asList(3, 4),
                        Arrays.asList(4, 1), Arrays.asList(4, 2), Arrays.asList(4, 3));
    }
}