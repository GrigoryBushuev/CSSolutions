package Primitives;

import org.junit.Assert;
import org.junit.Test;

public class ReverseBitsTest {

    @Test
    public void reverseBitsTest() {
        var sut = new ReverseBits();
        var result = sut.reverseBits(43261596);
        Assert.assertEquals(964176192, result);
    }
}
