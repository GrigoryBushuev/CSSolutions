package Primitives;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

public class PalindromeCheckTest {
    @Test
    public void isPalindromeTest(){
        var sut = new PalindromeCheck();
        var result = sut.isPalindrome(12321);
        Assert.assertTrue(result);
    }
}
