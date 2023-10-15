package Recursion.Subproblems;

import org.junit.jupiter.api.Test;

class TowersOfHanoiWithStackV2Test {

    @Test
    public void getMoves() {
        TowersOfHanoiWithStackV2 sut = new TowersOfHanoiWithStackV2();
        var moves = sut.getMoves(3);
    }
}