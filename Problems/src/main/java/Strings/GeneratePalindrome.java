package Strings;


import java.util.*;

/*
267. Palindrome Permutation II
Given a string s, return all the palindromic permutations (without duplicates) of it.
You may return the answer in any order. If s has no palindromic permutation, return an empty list.

Example 1:

Input: s = "aabb"
Output: ["abba","baab"]
Example 2:

Input: s = "abc"
Output: []

Constraints:

1 <= s.length <= 16
s consists of only lowercase English letters.
*/
public class GeneratePalindrome {
    public List<String> generatePalindromes(String s) {
        List<String> result = new LinkedList<>();
        HashMap<Character, Integer> charMap = new HashMap<>();
        for (var c : s.toCharArray()) {
            charMap.compute(c, (key, val) -> val == null ? 1 : val + 1);
        }
        String middleChar = "";
        TreeMap<Character, Integer> charCounts = new TreeMap<>();
        int oddNumber = 0;
        for (var charCount : charMap.entrySet()) {
            if (charCount.getValue() % 2 != 0) {
                middleChar = String.valueOf(charCount.getKey());
                var middleCharCount = charCount.getValue() / 2;
                if (middleCharCount > 0) {
                    charCounts.put(charCount.getKey(), middleCharCount);
                }
                oddNumber++;
                if (oddNumber > 1) {
                    return result;//can't create a palindrome
                }
            } else {
                charCounts.put(charCount.getKey(), charCount.getValue() / 2);
            }
        }
        generatePalindrome(charCounts, new StringBuilder(), middleChar, s.length() / 2, result);
        return result;
    }

    private static void generatePalindrome(TreeMap<Character, Integer> charCounts, StringBuilder path, String middleChar, int middlePos, List<String> result) {
        if (path.length() == middlePos) {
            var leftPart = path.toString();
            var rightPart = new StringBuilder(leftPart).reverse().toString();
            result.add(leftPart + middleChar + rightPart);
            return;
        }
        for (var key : charCounts.keySet()) {
            int charCount = charCounts.get(key);
            if (charCount == 0) {
                continue;
            }
            charCounts.put(key, charCount - 1);
            path.append(key);
            generatePalindrome(charCounts, path, middleChar, middlePos, result);
            path.deleteCharAt(path.length() - 1);
            charCounts.put(key, charCount);
        }
    }
}
