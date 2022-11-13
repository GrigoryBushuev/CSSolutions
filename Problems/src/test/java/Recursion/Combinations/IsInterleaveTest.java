package Recursion.Combinations;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

class IsInterleaveTest {

    @Test
    void isInterleaveTest() {
        var sut = new IsInterleave();
        Assert.assertTrue(sut.isInterleave("aabcc", "dbbca", "aadbbcbcac"));
        Assert.assertFalse(sut.isInterleave("a", "b", "a"));
        Assert.assertTrue(sut.isInterleave("a", "b", "ab"));
        Assert.assertTrue(sut.isInterleave("", "b", "b"));
        Assert.assertTrue(sut.isInterleave("", "", ""));
        Assert.assertFalse(sut.isInterleave("aabcc", "dbbca", "aadbbbaccc"));
    }
}