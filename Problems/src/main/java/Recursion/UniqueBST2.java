package Recursion;

import Trees.TreeNode;

import java.util.*;
import java.util.stream.IntStream;

/*
Input: 3
Output:
[
  [1,null,3,2],
  [3,2,null,1],
  [3,1,null,null,2],
  [2,1,3],
  [1,null,2,null,3]
]
Explanation:
The above output corresponds to the 5 unique BST's shown below:

   1         3     3      2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
   2     1         2                 3
*/

public class UniqueBST2 {
    public List<TreeNode> generateTrees(int n) {
        List result = new ArrayList<TreeNode>();
       // result.add(new TreeNode(0));
        return result;
    }

    private static int[] Swap(int[] arr, int i, int j) {
        var result = new int[arr.length];

        return result;
    }

    private static List<int[]> GeneratePermutations(List<int[]> result, int[] arr, int index) {
        if (index == arr.length - 1) {
            return result;
        }
        for (var i = 0; i < arr.length; i++) {
            var newArr = Swap(arr, i, arr.length - 1);
            result.addAll(GeneratePermutations(result, newArr, i + 1));
        }
        result.add(Arrays.stream(arr).toArray());
        return result;
    }

    public static List<int[]> GeneratePermutations(int size) {
        var result = new ArrayList<int[]>();
        var initialArr = IntStream.range(1, 4).toArray();
        return GeneratePermutations(result, initialArr, 0);
    }

    public static void main(String[] args) {
        for (var result : GeneratePermutations(3)) {
            for (var i : result) {
                System.out.println(i);
            }
        }
//        UniqueBST2 bst = new UniqueBST2();
//        for (TreeNode node : bst.generateTrees(3)) {
//            System.out.println(node.getValue());
//        }
    }
}




/**
 * [1, 2, 3], i = 0
 *  ^
 *    [2, 3, 1], i = 1
 *     ^
 *       [3, 1, 2], i = 2
 *
 *    [1, 3, 2] i = 0
 *
 *        [3, 2, 1] i = 1
 *
 *           [2, 1, 3] i = 2
 *
 *
 * ^
 * */
