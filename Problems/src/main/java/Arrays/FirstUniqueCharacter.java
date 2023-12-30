package Arrays;

/*
387. First Unique Character in a String
Given a string s, find the first non-repeating character in it and return its index. If it does not exist, return -1.

Example 1:
Input: s = "leetcode"
Output: 0

Example 2:
Input: s = "loveleetcode"
Output: 2

Example 3:
Input: s = "aabb"
Output: -1

Constraints:
1 <= s.length <= 10^5
s consists of only lowercase English letters.
*/
public class FirstUniqueCharacter {
    public int firstUniqChar(String s) {
        int[] freqMap = new int[26];

        char[] strArr = s.toCharArray();
        for (char c : strArr) {
            int charVal = c - 'a';
            freqMap[charVal] += 1;
        }

        for (int i = 0; i < strArr.length; i++) {
            int charVal = strArr[i] - 'a';
            if (freqMap[charVal] == 1) {
                return i;
            }
        }
        return -1;
    }
}