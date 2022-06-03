package BitManipulation;
import org.junit.Assert;
import org.junit.Test;

public class BitManipulationTest {
    @Test
    public void reverseBitsTest() {
        var sut = new BitManipulation();
        var result = sut.reverseBits(43261596);
        Assert.assertEquals(964176192, result);
    }

    @Test
    public void swapEndiannessTest() {
        var sut = new BitManipulation();
        var result = sut.swapEndianness(0x12345678);
        Assert.assertEquals(0x78563412, result);
    }

    @Test
    public void toBinaryStringTest() {
        var sut = new BitManipulation();
        var result = sut.toBinaryString(11);
        Assert.assertEquals("00000000000000000000000000001011", result);
    }

    @Test
    public void parseIntTest() {
        var sut = new BitManipulation();
//        var result = sut.parseLong("00000000000000000000000000001011", 2);
//        Assert.assertEquals(11, result);

        var result = sut.parseLong("10101010101010101010101010101010", 2);
        Assert.assertEquals(0x00000000AAAAAAAA, result);
    }

    @Test
    public void reverseBitsWithoutIterationsTest() {
        var sut = new BitManipulation();
        var result = sut.reverseBitsWithoutIterations(43261596);
        Assert.assertEquals(964176192, result);
    }

    @Test
    public void isPowerOf2Test() {
        var sut = new BitManipulation();
        var result = sut.isPowerOf2(8);
        Assert.assertTrue(result);

        result = sut.isPowerOf2(7);
        Assert.assertFalse(result);
    }

    @Test
    public void isPowerOfFourTest() {
        var sut = new BitManipulation();
        var result = sut.isPowerOfFour(16);
        Assert.assertTrue(result);
        result = sut.isPowerOfFour(8);
        Assert.assertFalse(false);
        result = sut.isPowerOfFour(17);
        Assert.assertFalse(false);
    }
}
