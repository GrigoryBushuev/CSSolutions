package DynamicProgramming;

/*
518. Coin Change II
You are given an integer array coins representing coins of different denominations and an integer amount representing a total amount of money.
Return the number of combinations that make up that amount. If that amount of money cannot be made up by any combination of the coins, return 0.
You may assume that you have an infinite number of each kind of coin.
The answer is guaranteed to fit into a signed 32-bit integer.

Example 1:
Input: amount = 5, coins = [1,2,5]
Output: 4
Explanation: there are four ways to make up the amount:
5=5
5=2+2+1
5=2+1+1+1
5=1+1+1+1+1

Example 2:
Input: amount = 3, coins = [2]
Output: 0
Explanation: the amount of 3 cannot be made up just with coins of 2.
Example 3:

Input: amount = 10, coins = [10]
Output: 1

Constraints:

1 <= coins.length <= 300
1 <= coins[i] <= 5000
All the values of coins are unique.
0 <= amount <= 5000
*/

public class CoinChange2 {
    /*
+---------+-----+---+---+---+---+---+
|  Coins  |  0  | 1 | 2 | 3 | 4 | 5 |
+---------+-----+---+---+---+---+---+
| {}      |  0  | 0 | 0 | 0 | 0 | 0 |
| {1}     | 1   | 1 | 1 | 1 | 1 | 1 |
| {1,2}   |   1 | 1 | 2 | 2 | 3 | 3 |
| {1,2,5} |   1 | 1 | 2 | 2 | 3 | 4 |
+---------+-----+---+---+---+---+---+
    1. 1 + 1 + 1 + 1 + 1 (1 combination for { 1 })
    2. 1 + 1 + 1 + 2
    3. 2 + 2 + 1 (2 combinations for { 1, 2 } + 1 combination for {1})
    4. 5 (1 combination for {1, 2, 5} + 2 combinations for { 1, 2 } + 1 combination for { 1 } )

    * Empty set will always produce 0 combinations
    * There is only 1 combination when the amount is 0
    * Number of Combinations for the current set of coins = Number of Combinations for the amount without the coin + Number of Combinations for the amount with the coin - Number of Combinations for the amount - coin value
    combinations[amount] = combinations[amount] + combinations[amount - coin]

    Time complexity: O(amount x number of coins)
    Space complexity: O(amount)
*/
    public int change(int amount, int[] coins) {
        var combinations = new int[amount + 1];
        combinations[0] = 1;
        for (var coin : coins) {
            for (var curAmount = coin; curAmount <= amount; curAmount++) {
                combinations[curAmount] = combinations[curAmount] + combinations[curAmount - coin];
            }
        }
        return combinations[amount];
    }
}
