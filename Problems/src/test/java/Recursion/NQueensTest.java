package Recursion;

import Recursion.Combinations.NQueens;
import org.junit.Test;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;

public class NQueensTest {
    @Test
    public void nQueensTest() {
        var sut = new NQueens();
        var result = sut.solveNQueens(4);
        //[[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
        assertThat(result)
                .isNotEmpty()
                .hasSize(2)
                .contains(
                        new ArrayList<>() {{ add(".Q.."); add("...Q"); add("Q..."); add("..Q.");}},
                        new ArrayList<>() {{ add("..Q."); add("Q..."); add("...Q"); add(".Q..");}}
                );

        result = sut.solveNQueens(1);
        //[["Q"]]
        assertThat(result)
                .isNotEmpty()
                .hasSize(1)
                .contains(
                        new ArrayList<>() {{ add("Q"); }}
                );

        result = sut.solveNQueens(5);
        //[["Q....","..Q..","....Q",".Q...","...Q."],
        // ["Q....","...Q.",".Q...","....Q","..Q.."],
        // [".Q...","...Q.","Q....","..Q..","....Q"],
        // [".Q...","....Q","..Q..","Q....","...Q."],
        // ["..Q..","Q....","...Q.",".Q...","....Q"],
        // ["..Q..","....Q",".Q...","...Q.","Q...."],
        // ["...Q.","Q....","..Q..","....Q",".Q..."],
        // ["...Q.",".Q...","....Q","..Q..","Q...."],
        // ["....Q",".Q...","...Q.","Q....","..Q.."],
        // ["....Q","..Q..","Q....","...Q.",".Q..."]]
        assertThat(result)
                .isNotEmpty()
                .hasSize(10)
                .contains(
                        new ArrayList<>() {{ add("Q...."); add("..Q.."); add("....Q"); add(".Q..."); add("...Q."); }},
                        new ArrayList<>() {{ add("Q...."); add("...Q."); add(".Q..."); add("....Q"); add("..Q.."); }},
                        new ArrayList<>() {{ add(".Q..."); add("...Q."); add("Q...."); add("..Q.."); add("....Q"); }},
                        new ArrayList<>() {{ add(".Q..."); add("....Q"); add("..Q.."); add("Q...."); add("...Q."); }},
                        new ArrayList<>() {{ add("..Q.."); add("Q...."); add("...Q."); add(".Q..."); add("....Q"); }},
                        new ArrayList<>() {{ add("..Q.."); add("....Q"); add(".Q..."); add("...Q."); add("Q...."); }},
                        new ArrayList<>() {{ add("...Q."); add("Q...."); add("..Q.."); add("....Q"); add(".Q..."); }},
                        new ArrayList<>() {{ add("...Q."); add(".Q..."); add("....Q"); add("..Q.."); add("Q...."); }},
                        new ArrayList<>() {{ add("....Q"); add(".Q..."); add("...Q."); add("Q...."); add("..Q.."); }},
                        new ArrayList<>() {{ add("....Q"); add("..Q.."); add("Q...."); add("...Q."); add(".Q..."); }}
                );
    }
}
