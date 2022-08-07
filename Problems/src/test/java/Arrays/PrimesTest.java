package Arrays;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

public class PrimesTest {

    @Test
    public void countPrimes() {
        var sut = new Primes();
        var result = sut.countPrimes(10);
        Assert.assertEquals(4, result);
    }
}
