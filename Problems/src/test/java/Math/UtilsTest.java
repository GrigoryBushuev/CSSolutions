package Math;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

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

    @Test
    public void getMinTimeDifference() {
        var sut = new Utils();
        var param = new ArrayList<String>();
        param.add("00:03");
        param.add("23:59");
        param.add("12:03");
        var result = sut.getMinTimeDifference(param);
        Assert.assertEquals(4, result);

        param.clear();
        param.add("00:01");
        param.add("23:59");
        param.add("23:56");
        result = sut.getMinTimeDifference(param);
        Assert.assertEquals(2, result);

        param.clear();
        param.add("01:01");
        param.add("02:01");
        param.add("03:00");
        result = sut.getMinTimeDifference(param);
        Assert.assertEquals(59, result);
    }
}
