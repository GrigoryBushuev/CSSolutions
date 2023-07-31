package Recursion.Permutations;
import java.util.*;

/*
Sorted Permutations. Write a permutation function that guarantees that the results are in sorted
order.

Function signature: List<List<Integer>> sortedPermutations(int[] arr)
eg.

sortedPermutations({3,2,1}) = [[1, 2, 3], [1, 3, 2], [2, 1, 3], [2, 3, 1], [3, 2, 1], [3, 1, 2]
*/
public class SortedPermutations {
    List<List<String>> getSortedPermutations(String[] arr) {
        Arrays.sort(arr);
        List<List<String>> result = new LinkedList<>();
        generatePermutations(arr, 0, new LinkedList<>(), result);
        return result;
    }

    private static void generatePermutations(String[] arr, int index, LinkedList<String> path, List<List<String>> result) {
        if (arr.length == index) {
            result.add(new LinkedList<>(path));
            return;
        }
        for (int i = index; i < arr.length; i++) {
            path.add(arr[i]);
            swap(arr, index, i);
            generatePermutations(arr, index + 1, path, result);
            swap(arr, index, i);
            path.removeLast();
        }
    }

    private static void swap(String[] arr, int left, int right) {
        String temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
    }
}
