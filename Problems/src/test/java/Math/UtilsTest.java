package Math;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

public class UtilsTest {
    @Test
    public void binaryExponentiationTest(){
        var sut = new Utils();
        var result = sut.binaryExponentiation(2, 16);
        Assert.assertEquals(65536, result, 0.0f);

        result = sut.binaryExponentiation(2, 17);
        Assert.assertEquals(131072, result, 0.0f);

        result = sut.binaryExponentiation(2, -1);
        Assert.assertEquals(0.5, result, 0.0f);

        result = sut.binaryExponentiation(2, -2);
        Assert.assertEquals(0.25, result, 0.0f);
    }
}
