package Strings;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

public class CanPermutePalindromeTest {

    @Test
    void canPermutePalindrome() {
        var sut = new CanPermutePalindrome();
        Assert.assertTrue(sut.canPermutePalindrome("a"));
        Assert.assertTrue(sut.canPermutePalindrome("aa"));
        Assert.assertTrue(sut.canPermutePalindrome("aaa"));
        Assert.assertTrue(sut.canPermutePalindrome("aba"));
        Assert.assertTrue(sut.canPermutePalindrome("abba"));
        Assert.assertFalse(sut.canPermutePalindrome("abc"));
    }
}