package Math;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class HappyNumberTest {

    @Test
    public void isHappyTest() {
        var sut = new HappyNumber();
        assertTrue(sut.isHappy(19));
        assertFalse(sut.isHappy(2));
    }

}