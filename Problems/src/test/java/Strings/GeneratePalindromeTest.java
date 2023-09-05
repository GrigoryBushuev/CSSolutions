package Strings;

import org.junit.jupiter.api.Test;

import java.util.Collections;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

public class GeneratePalindromeTest {

    @Test
    void generatePalindromes() {
        var sut = new GeneratePalindrome();
        var result = sut.generatePalindromes("aabb");
        assertThat(result)
                .isNotEmpty()
                .hasSize(2)
                .contains("abba", "baab");
        result = sut.generatePalindromes("abcba");
        assertThat(result)
                .isNotEmpty()
                .hasSize(2)
                .contains("abcba", "bacab");

        result = sut.generatePalindromes("aabbcc");
        assertThat(result)
                .isNotEmpty()
                .hasSize(6)
                .contains("abccba", "acbbca", "baccab", "bcaacb", "cabbac", "cbaabc");
        result = sut.generatePalindromes("abc");
        assertThat(result).isEmpty();
    }
}