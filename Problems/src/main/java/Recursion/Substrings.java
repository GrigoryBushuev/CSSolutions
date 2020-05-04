package Recursion;

import java.util.ArrayList;
import java.util.List;

public class Substrings {
    public static void getAllSubstrings(List<String> result, char[] arr, int index) {
        if (index == arr.length){
            return;
        }
        String str = "";
        for (int i = index; i < arr.length; i++) {
                str += arr[i];
                result.add(str);
        }
        getAllSubstrings(result, arr, index + 1);
    }

    public static List<String> getAllSubstrings(String str) {
        char[] arr = str.toCharArray();
        List<String> result = new ArrayList<>();
        getAllSubstrings(result, arr, 0);
        return result;
    }

    public static List<String> getAllSubstringsIter(String str) {
        char[] arr = str.toCharArray();
        List<String> result = new ArrayList<>();

        for (int index = 0; index < arr.length; index++) {
            String aggrStr = "";
            for (int i = index; i < arr.length; i++) {
                aggrStr += arr[i];
                result.add(aggrStr);
            }
        }
        return result;
    }
    
    public static void main(String[] args) {
        List<String> result = getAllSubstrings("abc");
        for (String s : result) {
            System.out.println(s);
        }
    }
}
