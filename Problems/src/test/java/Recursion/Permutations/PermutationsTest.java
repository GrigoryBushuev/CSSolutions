package Recursion.Permutations;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PermutationsTest {
    @Test
    public void getPermutations() {
        var sut = new AllPermutations();
        var result = sut.getPermutations(new Integer[] { 1, 2, 3 });
        assertThat(result)
                .isNotEmpty()
                .hasSize(6)
                .contains(new Integer[] { 1, 2, 3 }, new Integer[] { 1, 3, 2 }, new Integer[] { 2, 1, 3 }, new Integer[] { 2, 3, 1 }, new Integer[] { 3, 1, 2 }, new Integer[] { 3, 2, 1 });
    }
}