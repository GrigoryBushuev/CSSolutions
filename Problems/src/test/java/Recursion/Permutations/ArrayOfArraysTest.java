package Recursion.Permutations;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ArrayOfArraysTest {

    @Test
    public void arrayOfArraysTest() {
        var sut = new ArrayOfArrays();
        var result = sut.arrayOfArraysIterative(new int [][] { { 1, 2 }, { 3 }, { 4, 5 } });
    }

}