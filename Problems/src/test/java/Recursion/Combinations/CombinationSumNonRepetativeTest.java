package Recursion.Combinations;

import org.junit.jupiter.api.Test;
import java.util.LinkedList;
import static org.assertj.core.api.Assertions.assertThat;

public class CombinationSumNonRepetativeTest {

    @Test
    void combinationSumNonRepetativeTest() {
        var sut = new CombinationSumNonRepetative();
        var result = sut.getCombinationSumNonRepetative(3 ,7);
        assertThat(result)
                .isNotEmpty()
                .hasSize(1)
                .contains(
                        new LinkedList<>() {{ add(1); add(2); add(4); }}
                );

        result = sut.getCombinationSumNonRepetative(3 ,9);
        assertThat(result)
                .isNotEmpty()
                .hasSize(3)
                .contains(
                        new LinkedList<>() {{ add(1); add(2); add(6); }},
                        new LinkedList<>() {{ add(1); add(3); add(5); }},
                        new LinkedList<>() {{ add(2); add(3); add(4); }}
                );
    }
}
