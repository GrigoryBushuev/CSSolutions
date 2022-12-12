package DynamicProgramming;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

class BestTimeToBuyAndSellStockTest {

    @Test
    void maxProfitTest() {
        var sut = new BestTimeToBuyAndSellStock();
        var prices = new int[] { 7,1,5,3,6,4 };
        Assert.assertEquals(5, (sut.maxProfit(prices)));
        prices = new int[] { 7,6,4,3,1 };
        Assert.assertEquals(0, (sut.maxProfit(prices)));
    }
}