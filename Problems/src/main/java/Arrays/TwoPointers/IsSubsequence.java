package Arrays.TwoPointers;

/*392. Is Subsequence
Given two strings s and t, return true if s is a subsequence of t, or false otherwise.
A subsequence of a string is a new string that is formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (i.e., "ace" is a subsequence of "abcde" while "aec" is not).

Example 1:
Input: s = "abc", t = "gbahbgdc"
Output: true

Example 2:
Input: s = "axc", t = "ahbgdc"
Output: false


Constraints:
        0 <= s.length <= 100
        0 <= t.length <= 104
s and t consist only of lowercase English letters.

Follow up: Suppose there are lots of incoming s, say s1, s2, ..., sk where k >= 10^9, and you want to check one by one to see if t has its subsequence. In this scenario, how would you change your code?

The idea is that characters of the string t must appear with exactly the same sequence
as characters of the string s.
We're are going to have two pointers. The first pointer is going to iterate over string t and compare each character with
current character of the string s. When there is a match we increment the pointer of the string s.
If s is a subsequence of t it means that pointer of the string s will reach the number of characters in s.

Time complexity: O(t + s). We need to iterate over each character of the string t only once.
Space complexity: O(1). We use only variables to store pointers.
*/
public class IsSubsequence {
    public boolean isSubsequence(String s, String t) {
        int is = 0;
        for (int it = 0; it < t.length() && is < s.length(); it++) {
            if (s.charAt(is) == t.charAt(it)) {
                is++;
            }
        }
        return is == s.length();
    }
}
