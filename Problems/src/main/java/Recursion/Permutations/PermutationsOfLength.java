package Recursion.Permutations;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class PermutationsOfLength {

    public static <T> List<List<T>> getPermutationsOfLength(T[] arr, int length) {
        LinkedList<List<T>> result = new LinkedList<>();
        getPermutationsOfLength(arr, length, 0, new ArrayList<>(), result);
        return result;
    }

    private static <T> void getPermutationsOfLength(T[] arr, int length, int index, ArrayList<T> path, LinkedList<List<T>> result) {
        if (path.size() == length) {
            result.add(new ArrayList<>(path));
        }
        for (var i = index; i < arr.length; i++) {
            if (path.size() == length) {
                continue;
            }
            path.add(arr[i]);
            swap(arr, index, i);
            getPermutationsOfLength(arr, length, index + 1, path, result);
            path.remove(path.size() - 1);
            swap(arr, index, i);
        }
    }

    private static <T> void swap(T[] arr, int i, int j) {
        T temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
