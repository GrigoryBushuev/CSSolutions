package Recursion.Combinations;

import java.util.*;

public class StringPermutations {
    public List<String> getStringPermutations(String str) {
        LinkedList<String> result = new LinkedList<>();
        getPermutations(result, 0, str.toCharArray());
        result.add(str);
        return result;
    }

    private void swap(char[] arr, int i, int j) {
        var temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private void getPermutations(List<String> result, int index, char[] str) {
        if (index == str.length) {
            return;
        }
        for(var i = index + 1; i < str.length; i++) {
            var toAdd = Arrays.copyOf(str, str.length);
            swap(toAdd, index, i);
            result.add(new String(toAdd));
        }
        getPermutations(result, index + 1, str);
    }
}
