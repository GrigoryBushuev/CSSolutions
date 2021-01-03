package Recursion.Backtracking;

import java.util.*;

/*
* Given an array nums of distinct integers, return all the possible permutations. You can return the answer in any order.
* Example:
Input: nums = [1,2,3]
Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
*
* Solution 1: Backtracking
*   1. Start iterating from 0 to n
*   2. Exclude an i-th element from the array (this is our new element in the result array) and call the permutation recursively.
*   3. When we returned back from the recursion return the element back to where it was before to keep integrity of the initial array.
*
*   E.g.
*                                   [1, 2, 3], i = 0, index = 0; res = []
*
*          1, [2, 3], i = 0, res = [1]
*
*    1, 2, [3] i = 0, res = [1, 2]
*
* 1, 2, 3, i = 0, res = [1, 2, 3]
 */
public class Permutations<T> {
    private static <T> void Swap(T[] arr, int i, int j){
        T temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    /*
    * 123
    * 321
    *  ^
    * 312  321
    * */

    private static <T> void getPermutationsInternal(List<List<T>> result, T[] arr, int index) {
        if (index == arr.length - 1) {
            result.add(new ArrayList<>(Arrays.asList(arr)));
            return;
        }
        for (var i = index; i < arr.length; i++) {
            Swap(arr, index, i);
            getPermutationsInternal(result, arr, index + 1);
            Swap(arr, index, i);
        }
    }

    public static <T> List<? extends List<T>> getPermutations(T[] arr) {
        var result = new ArrayList<List<T>>();
        getPermutationsInternal(result, arr, 0);
        return result;
    }

    public static void main(String[] args) {
        var result = getPermutations(new Integer[] { 1, 2, 3 });
        for (var arr : result){
            System.out.println();
            for (var i : arr) {
                System.out.print(i);
            }
        }
    }
}
