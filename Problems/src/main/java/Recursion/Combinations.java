package Recursion;

import java.util.LinkedList;
import java.util.List;

public class Combinations {
    public static List<List<Integer>> getCombinations(int[] input){
        return getCombinations(input, 0);
    }

    private static List<List<Integer>> getCombinations(int[] input, int index){
        LinkedList<List<Integer>> result = new LinkedList<>();
        if (index == input.length){
            result.add(new LinkedList<>());
            return result;
        }
        for (List<Integer> toReturn : getCombinations(input, index + 1)){
            result.add(new LinkedList<>(toReturn));
            toReturn.add(0, input[index]);
            result.add(new LinkedList<>(toReturn));
        }
        return result;
    }

    public static void main(String[] args) {
        int[] data = { 0, 1, 2 };
        List<List<Integer>> result = Combinations.getCombinations(data);
        System.out.println(result);
    }

}
