package Recursion.Combinations;

import java.util.*;

public class InterleaveStrings {
    public List<String> getInterleavingStrings(String strA, String strB) {
        LinkedList<String> result = new LinkedList<>();
        generateInterleavingStrings(strA, strB, 0, 0,strA.length() + strB.length(), new StringBuilder(), result);
        return result;
    }

    private void generateInterleavingStrings(String strA, String strB, int aIndex, int bIndex, int length, StringBuilder current, LinkedList<String> result) {
        if (aIndex + bIndex == length) {
            result.add(current.toString());
            return;
        }
        var aToAdd = new StringBuilder(current);
        if (aIndex < strA.length()) {
            aToAdd.append(strA.charAt(aIndex));
            generateInterleavingStrings(strA, strB, aIndex + 1, bIndex, length, aToAdd, result);
        }
        var bToAdd = new StringBuilder(current);
        if (bIndex < strB.length()) {
            bToAdd.append(strB.charAt(bIndex));
            generateInterleavingStrings(strA, strB, aIndex, bIndex + 1, length, bToAdd, result);
        }
    }
}
