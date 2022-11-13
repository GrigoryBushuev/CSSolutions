package Recursion.Combinations;

public class IsInterleave {
    public static boolean isInterleave(String s1, String s2, String s3) {
        if (s1.equals("") && s2.equals("") && s3.equals("")) {
            return true;
        }
        return isInterleave(s1, s2, 0, 0, s3, new StringBuilder());
    }

    private static boolean isInterleave(String s1, String s2, int aIndex, int bIndex, String pattern, StringBuilder path) {
        if (pattern.length() < path.length()) {
            return false;
        }
        if ((aIndex > 0 || bIndex > 0) && !path.toString().equals(pattern.substring(0, aIndex + bIndex))) {
            return false;
        }
        if ((pattern.length() == (s1.length() + s2.length())) && pattern.equals(path.toString())) {
            return true;
        }
        if (aIndex < s1.length()) {
            path.append(s1.charAt(aIndex));
            if (isInterleave(s1, s2, aIndex + 1, bIndex, pattern, path)) {
                return true;
            }
            path.setLength(path.length() - 1);
        }
        if (bIndex < s2.length()) {
            path.append(s2.charAt(bIndex));
            if (isInterleave(s1, s2, aIndex, bIndex + 1, pattern, path)) {
                return true;
            }
            path.setLength(path.length() - 1);
        }
        return false;
    }
}
