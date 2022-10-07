package Recursion.Combinations;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class KnapsackZeroOneTest {

    @Test
    void getKnapsack() {
        var knapsackItems = new ArrayList<KnapsackZeroOne.KnapsackItem>() {{
            add(new KnapsackZeroOne.KnapsackItem(2, 4));
            add(new KnapsackZeroOne.KnapsackItem(1, 1));
            add(new KnapsackZeroOne.KnapsackItem(1, 3));
            add(new KnapsackZeroOne.KnapsackItem(1, 2));
            add(new KnapsackZeroOne.KnapsackItem(2, 3));
        }};
        var sut = new KnapsackZeroOne();
        var result = sut.getKnapsack(knapsackItems, 3);
        assertThat(result)
                .isNotEmpty()
                .hasSize(2)
                .contains(new KnapsackZeroOne.KnapsackItem(1, 3), new KnapsackZeroOne.KnapsackItem(2, 4));

        result = sut.getKnapsack(knapsackItems, 1);
        assertThat(result)
                .isNotEmpty()
                .hasSize(1)
                .contains(new KnapsackZeroOne.KnapsackItem(1, 3));

        result = sut.getKnapsack(knapsackItems, 7);
        assertThat(result)
                .isNotEmpty()
                .hasSize(5)
                .contains(
                        new KnapsackZeroOne.KnapsackItem(1, 1),
                        new KnapsackZeroOne.KnapsackItem(1, 2),
                        new KnapsackZeroOne.KnapsackItem(1, 3),
                        new KnapsackZeroOne.KnapsackItem(2, 3),
                        new KnapsackZeroOne.KnapsackItem(2, 4)
                );
    }
}