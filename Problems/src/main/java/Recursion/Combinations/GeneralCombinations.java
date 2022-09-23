package Recursion.Combinations;

import java.util.ArrayList;

public class GeneralCombinations {
    public ArrayList<ArrayList<Character>> combine(char[] arr) {
        return combine(new ArrayList<>(), arr, 0);
    }

    /*
    * Iterate over each node
    * Run recursion for the excluded node
    * Run recursion for the included node
    * Collect the result for all variations
    */
    private ArrayList<ArrayList<Character>> combine(ArrayList<Character> current, char[] arr, int index) {
        if (index == arr.length) {
            return new ArrayList<>() {{
                add(current);
            }};
        }
        var excludedResult = combine(current, arr, index + 1);
        var toAddNode = new ArrayList<>(current);
        toAddNode.add(arr[index]);
        var includeResult = combine(toAddNode, arr, index + 1);
        var result = new ArrayList<ArrayList<Character>>();
        result.addAll(excludedResult);
        result.addAll(includeResult);
        return result;
    }
}
