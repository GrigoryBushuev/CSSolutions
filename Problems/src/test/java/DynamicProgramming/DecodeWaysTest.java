package DynamicProgramming;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DecodeWaysTest {

    @Test
    public void numDecodingsTest() {
        var sut = new DecodeWays();
        var numberOfDecodings =  sut.numDecodings("12");
        assertEquals(2, numberOfDecodings);
        numberOfDecodings =  sut.numDecodings("226");
        assertEquals(3, numberOfDecodings);
        numberOfDecodings =  sut.numDecodings("06");
        assertEquals(0, numberOfDecodings);
        numberOfDecodings =  sut.numDecodings("0");
        assertEquals(0, numberOfDecodings);
        numberOfDecodings =  sut.numDecodings("10");
        assertEquals(1, numberOfDecodings);
        numberOfDecodings =  sut.numDecodings("102");
        assertEquals(1, numberOfDecodings);

    }

}