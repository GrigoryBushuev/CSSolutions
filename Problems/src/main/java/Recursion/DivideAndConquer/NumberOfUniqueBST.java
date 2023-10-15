package Recursion.DivideAndConquer;

/*
96. Unique Binary Search Trees
Given an integer n, return the number of structurally unique BST's (binary search trees) which has exactly n nodes of unique values from 1 to n.

Example 1:
Input: n = 3
Output: 5
Example 2:

Input: n = 1
Output: 1

Constraints:
1 <= n <= 19


Time complexity is: O(n^2) with caching
Space complexity is: O(n) to store intermediate result
*/


public class NumberOfUniqueBST {
    private static final int[] cache = new int[20];
    int getNumberOfUniqueBST(int n) {
        if (cache[n] != 0) {
            return cache[n];
        }
        if (n == 1) {
            return 1;
        }
        int total = 0;
        //Pickup each node as a root starting from 1.
        //as the number of variants in BST is symmetrical we can take till n/2
        for (int i = 1; i <= n >> 1; i++) {
            int leftOfTheRootNumber = 1;
            if (i > 2) {
                //Calculate the number of variants in the left subtree (before the root)
                leftOfTheRootNumber = getNumberOfUniqueBST(i - 1);
            }
            // Calculate the number of variants in the right subtree (after the root)
            // Total is the cartesian product of number of variants in the left subtree and number of variants
            // in the right subtree multiplied by 2
            total += 2 * leftOfTheRootNumber * getNumberOfUniqueBST(n - i);
        }
        // Special case handling when BST has odd number of roots.
        // As the number of variants in the left subtree is eqaul to number of variants in the right subtree
        // we calculate only one subtree and then do cartesian product to itself.
        if (n % 2 > 0) {
            int oneSideNumber = getNumberOfUniqueBST( n - ((n >> 1) + 1));
            total += oneSideNumber * oneSideNumber;
        }
        cache[n] = total;
        return total;
    }
}
