package Recursion.Combinations;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class GeneralCombinations {
    public List<List<Character>> combine(char[] arr) {
        //return combine(new LinkedList<>(), arr, 0);
        return getCombined(arr, 0);
    }

    /*
    * Iterate over each node
    * Run recursion for the excluded node
    * Run recursion for the included node
    * Collect the result for all variations
    */
    private List<List<Character>> getCombinedWithPassedParam(List<Character> current, char[] arr, int index) {
        if (index == arr.length) {
            return new LinkedList<>() {{
                add(current);
            }};
        }
        var excludedResult = getCombinedWithPassedParam(current, arr, index + 1);
        var toAddNode = new LinkedList<>(current);
        toAddNode.add(arr[index]);
        var includeResult = getCombinedWithPassedParam(toAddNode, arr, index + 1);
        LinkedList<List<Character>> result = new LinkedList<>();
        result.addAll(excludedResult);
        result.addAll(includeResult);
        return result;
    }

    private List<List<Character>> getCombined(char[] arr, int index) {
        if (index == arr.length) {
            //return empty element
            return new LinkedList<>() {{
               add(new LinkedList<>());
            }};
        }
        var combinedResults = getCombined(arr, index + 1);
        List<List<Character>> results = new LinkedList<>();
        for(var res : combinedResults) {
            //add excluded
            var toAdd = new ArrayList<>(res);
            results.add(toAdd);
            //create and add included
            res.add(0, arr[index]);
            results.add(res);
        }
        return results;
    }
}
