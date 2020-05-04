package Recursion;

import java.util.LinkedList;
import java.util.List;

public class Substrings {
    public static void getAllSubstrings(List<String> result, String str, int index) {
        if (index == str.length() + 1){
            return;
        }
        for (int endIndex = index; endIndex < str.length(); endIndex++) {
                result.add(str.substring(index, endIndex + 1));
        }
        getAllSubstrings(result, str, index + 1);
    }

    public static List<String> getAllSubstrings(String str) {
        List<String> result = new LinkedList<>();
        getAllSubstrings(result, str, 0);
        return result;
    }

    public static List<String> getAllSubstringsIter(String str) {
        char[] arr = str.toCharArray();
        List<String> result = new LinkedList<>();

        for (int begin = 0; begin < arr.length; begin++) {
            for (int end = begin; end < arr.length; end++) {
                result.add(str.substring(begin, end + 1));
            }
        }
        return result;
    }

    public static void main(String[] args) {
        List<String> result = getAllSubstringsIter("abc");
        for (String s : result) {
            System.out.println(s);
        }
    }
}
