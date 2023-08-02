package Recursion.Permutations;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

public class SeatingArrangementsTest {

    @Test
    public void arrangementsTest() {
        var sut = new SeatingArrangements();
        var result = sut.arrangements(3, new HashMap<>() { { put(1, 3); put(3, 1); }});
        assertThat(result)
                .isNotEmpty()
                .hasSize(4)
                .containsExactly(List.of(1, 3, 2), List.of(2, 1, 3), List.of(2, 3, 1), List.of(3, 1, 2));
    }
}