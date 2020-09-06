package Strings;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ReverseVowelsTest {
    @Test
    void reverseVowels_onNummParam_returns_expected_result() {
        assertThrows(IllegalArgumentException.class, () -> ReverseVowels.reverseVowels(null));
    }

    @Test
    void reverseVowels_onValidParams_returns_expected_result() {
        assertEquals("ewa", ReverseVowels.reverseVowels("awe"));
        assertEquals("cavi eslond", ReverseVowels.reverseVowels("cove island"));
        assertEquals("ceva islend or", ReverseVowels.reverseVowels("cove island er"));
        assertEquals("Aa", ReverseVowels.reverseVowels("aA"));
    }
}