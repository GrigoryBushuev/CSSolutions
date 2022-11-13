package Recursion.Combinations;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class StringPermutationsTest {

    @Test
    void getStringPermutations() {
        var sut = new StringPermutations();
        var result = sut.getStringPermutations("abc");
        assertThat(result)
                .isNotEmpty()
                .hasSize(4)
                .contains("abc", "bac", "cba", "acb");
    }
}