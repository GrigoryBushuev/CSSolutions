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

    @Test
    public void addStringsTest() {
        var sut = new Utils();
        var result = sut.addStrings("123", "456");
        Assert.assertEquals("579", result);

        result = sut.addStrings("146", "456");
        Assert.assertEquals("602", result);
        result = sut.addStrings("10146", "456");
        Assert.assertEquals("10602", result);

        result = sut.addStrings("9", "9");
        Assert.assertEquals("18", result);
    }
}
