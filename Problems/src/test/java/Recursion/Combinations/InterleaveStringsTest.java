package Recursion.Combinations;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


class InterleaveStringsTest {

    @Test
    public void getInterleavingStringsTest() {
        InterleaveStrings sut = new InterleaveStrings();
        var result = sut.getInterleavingStrings("ab", "cd");
        assertThat(result)
                .isNotEmpty()
                .hasSize(6)
                .contains("abcd", "acbd", "acdb", "cabd", "cadb", "cdab");
    }
}