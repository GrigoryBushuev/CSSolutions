package Recursion.Combinations;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.LinkedList;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class CombinationSumTest {

    @Test
    void combinationSumTest() {
        var sut = new CombinationSum();
        var result = sut.combinationSum(new int[] { 2, 3, 5 } ,8);
        assertThat(result)
                .isNotEmpty()
                .hasSize(3)
                .contains(
                        new LinkedList<>() {{ add(2); add(2); add(2); add(2);}},
                        new LinkedList<>() {{ add(2); add(3); add(3); }},
                        new LinkedList<>() {{ add(3); add(5); }}
                );

        result = sut.combinationSum(new int[] { 2, 3, 6, 7 } ,7);
        assertThat(result)
                .isNotEmpty()
                .hasSize(2)
                .contains(
                        new LinkedList<>() {{ add(2); add(2); add(3); }},
                        new LinkedList<>() {{ add(7); }}
                );
    }
}