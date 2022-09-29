package Recursion.Combinations;

import org.junit.Test;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;

public class CombinationsOfLengthTest {
    @Test
    public void CombinationsOfLengthTest() {
        var sut = new CombinationsOfLength();
        var result = sut.getCombinationsOfLength(new char[] { '1', '2', '3', '4' } ,2);
        assertThat(result)
                .isNotEmpty()
                .hasSize(6)
                .contains(
                        new ArrayList<>() {{ add('1'); add('2'); }},
                        new ArrayList<>() {{ add('1'); add('3'); }},
                        new ArrayList<>() {{ add('1'); add('4'); }},
                        new ArrayList<>() {{ add('2'); add('3'); }},
                        new ArrayList<>() {{ add('2'); add('4'); }},
                        new ArrayList<>() {{ add('3'); add('4'); }}
                );
    }
}
