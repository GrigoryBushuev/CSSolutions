package Strings;

/*
266. Palindrome Permutation
        Given a string s, return true if a permutation of the string could form a
        palindrome
        and false otherwise.

        Example 1:

        Input: s = "code"
        Output: false
        Example 2:

        Input: s = "aab"
        Output: true
        Example 3:

        Input: s = "carerac"
        Output: true


        Constraints:

        1 <= s.length <= 5000
        s consists of only lowercase English letters.
 */
public class CanPermutePalindrome {
    /*
        1. Check for duplicates
          aba a-2, b-1 (3) - v
          abba a-2, b-2 (4) - v
          aaab a-3, b-1 (4) - i
          ababa a-3, b-2 (5) - v
          aaabbb a-3, b-3 (6) - i
          abccba a-2, b-2, c-2 (6) - v
        2. Palindrome */
    public boolean canPermutePalindrome(String s) {
        //create an empty bitmask
        int result = 0;
        //for every symbol we set a bit from 0 to 26. If the bit was already set we reset it to 0 with xor operation.
        for (var i = 0; i < s.length(); i++) {
            result ^= 1 << (s.charAt(i) - 'a');
        }
        //Eventually, the input can permute a palindrome when all bits were flipped even number of times, so they all become set to 0.
        //Or only single bit will remained set when the input string length is odd.
        return result == 0 || (result & (result - 1)) == 0;
    }
}
