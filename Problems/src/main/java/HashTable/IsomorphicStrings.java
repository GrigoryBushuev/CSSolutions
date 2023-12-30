package HashTable;

/*
205. Isomorphic Strings

Given two strings s and t, determine if they are isomorphic.
Two strings s and t are isomorphic if the characters in s can be replaced to get t.
All occurrences of a character must be replaced with another character while preserving the order of characters. No two characters may map to the same character, but a character may map to itself.

Example 1:
Input: s = "egg", t = "add"
Output: true

Example 2:
Input: s = "foo", t = "bar"
Output: false

Example 3:
Input: s = "pacer", t = "title"
Output: false

Example 4:
Input: s = "paper", t = "title"
Output: true

Example 5:
Input: s = "badc", t = "baba"
Output: false
*/
public class IsomorphicStrings {
    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] sDic = new int[256];
        int[] tDic = new int[256];

        for (int i = 0; i < s.length(); i++) {
            char sChar = s.charAt(i);
            char tChar = t.charAt(i);

            if (sDic[sChar] == 0) {
                sDic[sChar] = tChar;
            }
            if (tDic[tChar] == 0) {
                tDic[tChar] = sChar;
            }
            if (sDic[sChar] != tChar || tDic[tChar] != sChar) {
                return false;
            }
        }
        return true;
    }
/*
* The idea is to put
* */
//    public boolean isIsomorphic(String s, String t) {
//        if (s.length() != t.length()) {
//            return false;
//        }
//        int size = s.length();
//        int[] sArray = new int[size];
//        int[] tArray = new int[size];
//        int sVal = 1;
//        int tVal = 1;
//        for (int i = 0; i < size; i++) {
//            if (sArray[i] == 0) {
//                char sChar = s.charAt(i);
//                for (int j = i; j < size; j++) {
//                    if (s.charAt(j) == sChar) {
//                        sArray[j] = sVal;
//                    }
//                }
//                sVal++;
//            }
//            if (tArray[i] == 0) {
//                char tChar = t.charAt(i);
//                for (int j = i; j < size; j++) {
//                    if (t.charAt(j) == tChar) {
//                        tArray[j] = tVal;
//                    }
//                }
//                tVal++;
//            }
//        }
//
//        for (int j = 0; j < size; j++) {
//            if (sArray[j] != tArray[j]) {
//                return false;
//            }
//        }
//        return true;
//    }
}
