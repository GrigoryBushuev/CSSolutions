package Recursion.DivideAndConquer;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class NumberOfUniqueBSTTest {

    @Test
    public void getNumberOfUniqueBST() {
        var sut = new NumberOfUniqueBST();
        assertEquals(5, sut.getNumberOfUniqueBST(3));
        assertEquals(14, sut.getNumberOfUniqueBST(4));
        assertEquals(42, sut.getNumberOfUniqueBST(5));
        assertEquals(132, sut.getNumberOfUniqueBST(6));
    }
}