package Recursion;
import java.util.*;

public class Parenthesis {
    private ArrayList<String> result = null;
    private int n;

    private boolean isValidOpenBracket(char[] parentheses, int position) {
        var openBracketCount = 0;
        for (var i = 0; i < position; i++) {
            if (parentheses[i] == '(') {
                openBracketCount++;
            }
        }
        return openBracketCount < n;
    }

    private boolean isValidCloseBracket(char[] parentheses, int position) {
        var openBracketCount = 0;
        var closeBracketCount = 0;
        for (var i = 0; i < position; i++) {
            if (parentheses[i] == '(') {
                openBracketCount++;
            } else {
                closeBracketCount++;
            }
        }
        return openBracketCount > closeBracketCount;
    }

    private void generateParenthesis(int position, int max, char[] parentheses) {
        if (position == max - 1) {
            parentheses[position] = ')';
            this.result.add(new String(parentheses));
            return;
        }
        var temp = Arrays.copyOf(parentheses, max);
        if (isValidOpenBracket(parentheses, position)) {
            temp[position] = '(';
            generateParenthesis(position + 1, max, temp);
        }
        if (isValidCloseBracket(parentheses, position)) {
            temp[position] = ')';
            generateParenthesis(position + 1, max, temp);
        }
    }

    public List<String> generateParenthesis(int n) {
        this.result = new ArrayList<>();
        this.n = n;
        if (n == 1) {
            this.result.add("()");
            return this.result;
        }
        var parenthesis = new char[n << 1];
        parenthesis[0] = '(';
        generateParenthesis(1, n << 1, parenthesis);
        return this.result;
    }
}
