package Recursion;

import java.util.ArrayList;
import java.util.List;

public class Combinations {
    public static List<String> getCombinations(String input){
        List<String> result = new ArrayList<>();
        getCombinations(result, input.toCharArray(), 0);
        return result;
    }

    private static void getCombinations(List<String> result, char[] input, int index) {
        if (index == input.length) {
            return;
        }
        int len = result.size();
        for (var i = 0; i < len; i++) {
            result.add(result.get(i) + input[index]);
        }
        result.add(new String(new char[] { input[index] }));
        getCombinations(result, input, index + 1);
    }

    public static void main(String[] args) {
        final String abcStr = "abc";
        var result = Combinations.getCombinations(abcStr);
        System.out.println(result);
    }

    //[[a], [a, b], [b], [a,c], [a,b,c], [b,c], [c]]
}
