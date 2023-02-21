package Recursion.Permutations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

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
*   [1, 2, 3], i = 0, index = 0; res = []
*
*    1, [2, 3], i = 0, res = [1]
*
*    1, 2, [3] i = 0, res = [1, 2]
*
*    1, 2, 3, i = 0, res = [1, 2, 3]
 */
public class Permutations {

    private static <T> void swap(T[] arr, int i, int j) {
        T temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static <T> LinkedList<T[]> getPermutations(T[] arr) {
        LinkedList<T[]> result = new LinkedList<>();
        getPermutations(new ArrayList<>(Arrays.asList(arr)), new LinkedList<T>(), result);
        return result;
    }

    private static <T> void getPermutations(ArrayList<T> input, LinkedList<T> path, LinkedList<T[]> result) {
        if (input.size() == 0) {
            T[] res = (T[]) path.toArray();
            result.add(res);
            return;
        }
        for (var i = 0; i < input.size(); i++) {
            var num = input.remove(i);
            path.add(num);
            getPermutations(input, path, result);
            path.removeLast();
            input.add(i, num);
        }
    }

    /*private static <T> void getPermutations(T[] arr, int index, LinkedList<T[]> result) {
        if (index == arr.length - 1) {
            result.add(arr.clone());
            return;
        }
        for (var i = index; i < arr.length; i++) {
            swap(arr, index, i);
            getPermutations(arr, index + 1, result);
            swap(arr, index, i);
        }
    }*/
}
