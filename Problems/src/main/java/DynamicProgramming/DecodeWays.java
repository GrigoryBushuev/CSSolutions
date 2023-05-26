package DynamicProgramming;

import java.util.HashMap;

import static java.lang.String.valueOf;

/*
91. Decode Ways
A message containing letters from A-Z can be encoded into numbers using the following mapping:

'A' -> "1"
'B' -> "2"
...
'Z' -> "26"
To decode an encoded message, all the digits must be grouped then mapped back into letters using the reverse of the mapping above (there may be multiple ways). For example, "11106" can be mapped into:

"AAJF" with the grouping (1 1 10 6)
"KJF" with the grouping (11 10 6)
Note that the grouping (1 11 06) is invalid because "06" cannot be mapped into 'F' since "6" is different from "06".

Given a string s containing only digits, return the number of ways to decode it.
The test cases are generated so that the answer fits in a 32-bit integer.

Example 1:
Input: s = "12"
Output: 2
Explanation: "12" could be decoded as "AB" (1 2) or "L" (12).

Example 2:
Input: s = "226"
Output: 3
Explanation: "226" could be decoded as "BZ" (2 26), "VF" (22 6), or "BBF" (2 2 6).

Example 3:
Input: s = "06"
Output: 0
Explanation: "06" cannot be mapped to "F" because of the leading zero ("6" is different from "06").

Constraints:
1 <= s.length <= 100
s contains only digits and may contain leading zero(s).
*/
public class DecodeWays {
    private static boolean isValid(String str) {
        if (str.length() == 0 || str.charAt(0) == '0') {
            return false;
        }
        if (str.length() == 1) {
            return true;
        }
        var val = str.charAt(0);
        if (val == '1') {
            return true;
        } else if (val == '2' && str.charAt(1) <= '6') {
            return true;
        }
        return false;
    }

    public int numDecodings(String s) {
        int twoDigitNumber = 1;
        int oneDigitNumber = s.charAt(0) == '0' ? 0 : 1;
        for (int i = 2; i <= s.length(); i++) {
            int currentValue = 0;
            var oneDigitStr = s.substring(i - 1, i);
            if (isValid(oneDigitStr)) {
                currentValue += oneDigitNumber;
            }
            var twoDigitStr = s.substring(i - 2, i);
            if (isValid(twoDigitStr)) {
                currentValue += twoDigitNumber;
            }
            twoDigitNumber = oneDigitNumber;
            oneDigitNumber = currentValue;
        }
        return oneDigitNumber;
    }

//    public int numDecodings(String s) {
//        HashMap<Integer, Integer> cache = new HashMap<>();
//        return getNumberOfDecodings(s, 0, cache);
//    }

    private int getNumberOfDecodings(String nums, int index, HashMap<Integer, Integer> cache) {
        if (cache.containsKey(index)) {
            return cache.get(index);
        }
        if (nums.length() == 1) {
            return isValid(nums.substring(index, index + 1)) ? 1 : 0;
        }
        if (index == nums.length()) {
            return 1;
        }
        var oneDigitNumber = 0;
        if (isValid(nums.substring(index, index + 1))) {
            oneDigitNumber = getNumberOfDecodings(nums, index + 1, cache);
        }
        var twoDigitsNumber = 0;
        if (index + 1 < nums.length() && isValid(nums.substring(index, index + 2))) {
            twoDigitsNumber = getNumberOfDecodings(nums, index + 2, cache);
        }
        var total = oneDigitNumber + twoDigitsNumber;
        cache.put(index, total);
        return total;
    }
}
