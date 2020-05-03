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
        assertEquals(ReverseVowels.reverseVowels("awe"), "ewa");
        assertEquals(ReverseVowels.reverseVowels("cove island"), "cavi eslond");
        assertEquals(ReverseVowels.reverseVowels("cove island er"), "ceva islend or");
        assertEquals(ReverseVowels.reverseVowels("aA"), "Aa");
    }
}