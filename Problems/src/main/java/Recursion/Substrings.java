package Recursion;

import java.util.LinkedList;
import java.util.List;

public class Substrings {
    private static void getSubstrings(List<String> result, String str, int begin, int end) {
        if (end > str.length()) {
            begin++;
            if (begin == str.length()) {
                return;
            }
            end = begin + 1;
        }
        result.add(str.substring(begin, end));
        getSubstrings(result, str, begin, end + 1);
    }

    public static List<String> getSubstrings(String str) {
        List<String> result = new LinkedList<>();
        getSubstrings(result, str, 0, 1);
        return result;
    }

    public static List<String> getSubstringsIter(String str) {
        List<String> result = new LinkedList<>();
        for (int i = 0; i < str.length(); i++) {
            for (int j = i + 1; j <= str.length(); j++) {
                result.add(str.substring(i, j));
            }
        }
        return result;
    }

//    public static List<String> getAllSubstringsIter(String str) {
//        List<String> result = new LinkedList<>();
//        char[] arr = str.toCharArray();
//        for (int i = 0; i < arr.length; i++) {
//            String temp = "";
//            for (int j = i; j < arr.length; j++){
//                temp += arr[j];
//                result.add(temp);
//            }
//        }
//        return result;
//    }

    public static void main(String[] args) {
        List<String> result = getSubstrings("abc");
        for (String s : result) {
            System.out.println(s);
        }
    }
}
