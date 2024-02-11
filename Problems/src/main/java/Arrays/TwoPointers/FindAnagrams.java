package Arrays.TwoPointers;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

/*438. Find All Anagrams in a String
Given two strings s and p, return an array of all the start indices of p's anagrams in s. You may return the answer in any order.
An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.

Example 1:
Input: s = "cbaebabacd", p = "abc"
Output: [0,6]
Explanation:
The substring with start index = 0 is "cba", which is an anagram of "abc".
The substring with start index = 6 is "bac", which is an anagram of "abc".

Example 2:
Input: s = "abab", p = "ab"
Output: [0,1,2]
Explanation:
The substring with start index = 0 is "ab", which is an anagram of "ab".
The substring with start index = 1 is "ba", which is an anagram of "ab".
The substring with start index = 2 is "ab", which is an anagram of "ab".

Constraints:
1 <= s.length, p.length <= 3 * 104
s and p consist of lowercase English letters.
*/
public class FindAnagrams {
    // Each anagram contains the same number of characters. E.g. abc, acb, bac, bca, cab, cba is a - 1, b - 1, c - 1
    //1. Build a map of a pattern string. As s and p consist of lowercase English letters we can use an integer array int[26]
    //2. Move pointer j from 0 to s.length() and build the same map of size p.length() for the string s.
    //3. When pointer j becomes larger than size of the window then remove previous first character from the map
    //4. If map of p equals to map of s then add index of the beginning of substring to the result (j - sizeof(p)).
    public List<Integer> findAnagrams(String s, String p) {
        int sLength = s.length();
        int pLength = p.length();
        List<Integer> result = new ArrayList<>();
        if (sLength < pLength) {
            return result;
        }

        int[] pArr = new int[26];
        int[] sArr = new int[26];
        for (int i = 0; i < pLength; i++) {
            pArr[(p.charAt(i) - 'a')] += 1;
        }

        for (int j = 0; j < sLength; j++) {
            sArr[(s.charAt(j) - 'a')] += 1;
            if (j >= pLength) {
                sArr[(s.charAt(j - pLength) - 'a')] -= 1;
            }
            if (Arrays.equals(sArr, pArr)) {
                result.add(j - pLength + 1);
            }
        }
        return result;
    }
}
