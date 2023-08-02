package Recursion.Permutations;
import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class SortedPermutationsTest {
    @Test
    public void getSortedPermutations() {
        var sut = new SortedPermutations();
        var result = sut.getSortedPermutations(new String[] { "3", "2", "1" });
        assertThat(result)
                .isNotEmpty()
                .hasSize(6)
                .containsExactly(List.of( "1", "2", "3" ), List.of( "1", "3", "2" ), List.of( "2", "1", "3" ), List.of( "2", "3", "1" ), List.of( "3", "2", "1" ), List.of( "3", "1", "2" ));
    }
}