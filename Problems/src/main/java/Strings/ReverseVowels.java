package Strings;
import java.util.HashSet;
import java.util.Set;

public class ReverseVowels {
    private static final Set<Character> Vowels = new HashSet<>();
    static {
        Vowels.add('A');
        Vowels.add('E');
        Vowels.add('I');
        Vowels.add('O');
        Vowels.add('U');
        Vowels.add('a');
        Vowels.add('e');
        Vowels.add('i');
        Vowels.add('o');
        Vowels.add('u');
    }

    private static void Swap(StringBuilder sb, int i , int j) {
        char temp = sb.charAt(j);
        sb.setCharAt(j, sb.charAt(i));
        sb.setCharAt(i, temp);
    }

    public static String reverseVowels(String str) throws IllegalArgumentException {
        if (str == null || str.trim().length() == 0) {
            throw new IllegalArgumentException("str parameter is empty or null");
        }
        StringBuilder sb = new StringBuilder(str);
        int i = 0;
        int j = str.length() - 1;

        while (i < j) {
            while (!Vowels.contains(sb.charAt(i))) {
                i++;
            }
            while (!Vowels.contains(sb.charAt(j))) {
                j--;
            }
            if (i >= j) {
                break;
            }
            Swap(sb, i, j);
            i++;
            j--;
        }
        return sb.toString();
    }
}
