package Recursion.Combinations;

import java.util.*;

public class InterleaveStrings {
    public static List<String> getInterleavingStrings(String strA, String strB) {
        LinkedList<String> result = new LinkedList<>();
        generateInterleavingStrings(strA, strB, 0, 0,strA.length() + strB.length(), new StringBuilder(), result);
        return result;
    }

    private static void generateInterleavingStrings(String strA, String strB, int aIndex, int bIndex, int length, StringBuilder path, LinkedList<String> result) {
        if (aIndex + bIndex == length) {
            result.add(path.toString());
            return;
        }
        if (aIndex < strA.length()) {
            path.append(strA.charAt(aIndex));
            generateInterleavingStrings(strA, strB, aIndex + 1, bIndex, length, path, result);
            path.setLength(path.length() - 1);
        }
        if (bIndex < strB.length()) {
            path.append(strB.charAt(bIndex));
            generateInterleavingStrings(strA, strB, aIndex, bIndex + 1, length, path, result);
            path.setLength(path.length() - 1);
        }
    }
}
