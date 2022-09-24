package Recursion.Combinations;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class GeneralCombinations {
    public List<List<Character>> combine(char[] arr) {
        return combine(new ArrayList<>(), arr, 0);
    }

    /*
    * Iterate over each node
    * Run recursion for the excluded node
    * Run recursion for the included node
    * Collect the result for all variations
    */
    private List<List<Character>> combine(List<Character> current, char[] arr, int index) {
        if (index == arr.length) {
            return new LinkedList<>() {{
                add(current);
            }};
        }
        var excludedResult = combine(current, arr, index + 1);
        var toAddNode = new LinkedList<>(current);
        toAddNode.add(arr[index]);
        var includeResult = combine(toAddNode, arr, index + 1);
        LinkedList<List<Character>> result = new LinkedList<>();
        result.addAll(excludedResult);
        result.addAll(includeResult);
        return result;
    }
}
