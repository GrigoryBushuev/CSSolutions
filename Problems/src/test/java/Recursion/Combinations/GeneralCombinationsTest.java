package Recursion.Combinations;

import org.junit.Test;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;

public class GeneralCombinationsTest {

    @Test
    public void CombinationsTest() {
        var sut = new GeneralCombinations();
        var result = sut.combine(new char[] { '1', '2', '3' });
        assertThat(result)
                .isNotEmpty()
                .hasSize(8)
                .contains(new ArrayList<Character>(),
                        new ArrayList<>() {{ add('1'); }},
                        new ArrayList<>() {{ add('2'); }},
                        new ArrayList<>() {{ add('3'); }},
                        new ArrayList<>() {{ add('1'); add('2'); }},
                        new ArrayList<>() {{ add('1'); add('3'); }},
                        new ArrayList<>() {{ add('2'); add('3'); }},
                        new ArrayList<>() {{ add('1'); add('2'); add('3'); }}
                );
    }
}
