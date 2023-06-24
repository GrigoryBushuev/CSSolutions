package Recursion.Permutations;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class NextPermutationTest {
    @Test
    void nextPermutation() {
        var sut = new NextPermutation();
        var arr = new int[] { 1, 2, 3, 4 };
        sut.nextPermutation(arr);
        assertThat(arr)
                .isNotEmpty()
                .hasSize(4)
                .containsExactly(1, 2, 4, 3);

        sut.nextPermutation(arr);
        assertThat(arr)
                .isNotEmpty()
                .hasSize(4)
                .containsExactly(1, 3, 2, 4);

        sut.nextPermutation(arr);
        assertThat(arr)
                .isNotEmpty()
                .hasSize(4)
                .containsExactly(1, 3, 4, 2 );

        sut.nextPermutation(arr);
        assertThat(arr)
                .isNotEmpty()
                .hasSize(4)
                .containsExactly(1, 4, 2, 3 );

        sut.nextPermutation(arr);
        assertThat(arr)
                .isNotEmpty()
                .hasSize(4)
                .containsExactly(1, 4, 3, 2 );

        sut.nextPermutation(arr);
        assertThat(arr)
                .isNotEmpty()
                .hasSize(4)
                .containsExactly(2, 1, 3, 4 );

        arr = new int[] { 3, 2, 1 };
        sut.nextPermutation(arr);
        assertThat(arr)
                .isNotEmpty()
                .hasSize(3)
                .containsExactly(1, 2, 3 );

        //duplicate value test
        arr = new int[] { 3, 4, 9, 5, 4, 3, 2 };
        sut.nextPermutation(arr);
        assertThat(arr)
                .isNotEmpty()
                .hasSize(7)
                .containsExactly(3, 5, 2, 3, 4, 4, 9 );
    }
}