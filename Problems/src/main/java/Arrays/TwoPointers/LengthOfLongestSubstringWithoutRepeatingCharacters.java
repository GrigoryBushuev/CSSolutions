package Arrays.TwoPointers;

import java.util.Map;
import java.util.HashMap;

/*3. Longest Substring Without Repeating Characters
Given a string s, find the length of the longest substring without repeating characters.

Example 1:
Input: s = "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.

Example 2:
Input: s = "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.

Example 3:
Input: s = "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3.
Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.

Example 4:
Input: s = "tmmzuxt"
Output: 5
Explanation: The answer is "mzuxt", with the length of 5.
!!!Notice that first occurrence of the duplicate 'm' happens for the character that is to the right of the next duplicate 't'.

Constraints:
0 <= s.length <= 5 * 10^4
s consists of English letters, digits, symbols and spaces.

We're going to have two pointers, maxLength to store the result and a HashMap. The right pointer is going to iterate over each characters of the string from 0 till the end of the string and check if the character is present in the map.
If the character is not present in the map then we calculate current maxLength as difference between right and left pointers and compare it with the max length that was found so far. We assign the biggest value to the max length variable.
If the character is present in the map it means that we have a duplicate and we move the left pointer to the previous position of the duplicate + 1.
We put current character as a key and the current position of the character as a value  to the hashmap on each iteration.

Time complexity: O(n) linear as we iterate over each character only once
Space complexity: O(n) as we have to store every character of the string
*/
public class LengthOfLongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        int sLen = s.length();
        if (sLen < 2) {
            return sLen;
        }

        int maxLength = 0, left = 0;
        Map<Character, Integer> charactersPositions = new HashMap<>();
        for (int right = 0; right < sLen; right++) {
            char ch = s.charAt(right);
            Integer lastPosition = charactersPositions.get(ch);
            if (lastPosition == null || lastPosition < left) {
                maxLength = Math.max(maxLength, right - left + 1);
            } else {
                left = lastPosition + 1;
            }
            charactersPositions.put(ch, right);
        }
        return maxLength;
    }
}
