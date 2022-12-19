package DynamicProgramming;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

class UniquePathsTest {

    @Test
    void maxProfitTest() {
        var sut = new UniquePaths();
        Assert.assertEquals(28, sut.uniquePaths(3, 7));
        Assert.assertEquals(3, sut.uniquePaths(3, 2));
    }
}