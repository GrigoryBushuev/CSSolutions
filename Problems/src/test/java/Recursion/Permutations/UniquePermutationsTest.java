package Recursion.Permutations;

import java.util.*;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class UniquePermutationsTest {

    @Test
    public void uniquePermutationsTest() {
        var sut = new UniquePermutations();
        var result = sut.permuteUnique(new int[] { 1, 1, 2 });
        assertThat(result)
                .isNotEmpty()
                .hasSize(3)
                .contains(Arrays.asList( 1, 1, 2 ), Arrays.asList( 1, 2, 1 ), Arrays.asList( 2, 1, 1 ));

        result = sut.permuteUnique(new int[] { 1, 2, 3 });
        assertThat(result)
                .isNotEmpty()
                .hasSize(6)
                .contains(Arrays.asList( 1, 2, 3 ), Arrays.asList( 1, 3, 2 ), Arrays.asList( 2, 1, 3 ), Arrays.asList( 2, 3, 1 ), Arrays.asList( 3, 1, 2 ), Arrays.asList( 3, 2, 1 ));
    }
}