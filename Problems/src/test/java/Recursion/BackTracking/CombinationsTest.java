package Recursion.BackTracking;
import Recursion.Combinations;
import org.junit.Assert;
import org.junit.Test;
import static org.assertj.core.api.Assertions.assertThat;

import java.sql.Array;
import java.util.*;

public class CombinationsTest {

    @Test
    public void CombinationsTest() {
        var sut = new Combinations();
        var result = sut.combine(4, 2);
        assertThat(result)
                .isNotEmpty()
                .hasSize(6)
                .contains(Arrays.asList(1,2),Arrays.asList(1,3),Arrays.asList(1,4),Arrays.asList(2,3),Arrays.asList(2,4),Arrays.asList(3,4));
    }
}
