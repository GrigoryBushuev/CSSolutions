package Math;

import javax.print.DocFlavor;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

public class Utils {

    /*2^17 = 2^8 * 2^8 * 2^1
     *
     * 1) result = a * 1 = a; a = a ^ 2; n = 8;
     * 2) result = a; a = a ^ 2 * a ^ 2 = a ^ 4; n = 4;
     * 3) result = a; a = a ^ 4 * a ^ 4 = a ^ 8; n = 2;
     * 4) result = a; a = a ^ 8 * a ^ 8 = a ^ 16; n = 1;
     * 5) return result * a; return a * a ^ 16;
     */
    public static double binaryExponentiation(double a, int n) {
        if (n == 0) {
            return 1;
        }
        if (n == 1) {
            return a;
        }
        if (n < 0) {
            a = 1 / a;
            n = -n;
        }
        var result = 1;
        while (n > 1) {
            if ((n & 1) == 1) {
                result *= a;
            }
            a *= a;
            n >>>= 1;
        }
        return result * a;
    }

    public String addStrings(String a, String b) {
        var sb = new StringBuilder();
        var aPointer = a.length() - 1;
        var bPointer = b.length() - 1;
        var carriedValue = 0;
        while (aPointer >= 0 || bPointer >= 0 || carriedValue > 0) {
            var aValue = 0;
            var bValue = 0;
            if (aPointer >= 0) {
                aValue = a.charAt(aPointer) - '0';
                aPointer--;
            }
            if (bPointer >= 0) {
                bValue = b.charAt(bPointer) - '0';
                bPointer--;
            }
            var sum = aValue + bValue  + carriedValue;
            var result = sum % 10;
            carriedValue = sum / 10;
            sb.append(result);
        }
        return sb.reverse().toString();
    }

    private List<Integer> getMins(List<String> times) {
        var result = new ArrayList<Integer>();
        for (var time : times) {
            var hh = (time.charAt(0) - '0') * 10 + (time.charAt(1) - '0');
            var mm = (time.charAt(3) - '0') * 10 + (time.charAt(4) - '0');
            result.add(hh * 60 + mm);
        }
        return result;
    }

    public int getMinTimeDifference(List<String> times) {
        var mins = getMins(times);
        Collections.sort(mins);
        var prev = mins.get(0);
        var result = Integer.MAX_VALUE;
        for (var i = 1; i < mins.size(); i++) {
            var current = mins.get(i);
            result = Math.min(result, Math.abs(current - prev));
            prev = current;
        }
        result = Math.min(result, mins.get(0) + 1440 - prev);
        return result;
    }

    public String changeBase(String numAsString, int fromBase, int toBase) {
        if (fromBase == toBase) {
            return numAsString;
        }
        if (numAsString == null) {
            throw new NullPointerException();
        }
        if (fromBase < 2 || toBase < 2) {
            throw new IllegalArgumentException();
        }
        String sign = "";
        int startIndex = 0;
        if (numAsString.charAt(0) == '-') {
            sign = "-";
            startIndex = 1;
        }
        var decNumber = convertToDecimal(numAsString, fromBase, startIndex);
        return sign + convertDecToBase(decNumber, toBase);
    }

    private static int convertToDecimal(String numAsString, int fromBase, int startindex) {
        numAsString = numAsString.toUpperCase();
        var result = 0;
        var decimalNumber = 0;
        var j = numAsString.length() - 1;
        for (int i = startindex; i < numAsString.length(); i++, j--) {
            var currentChar = numAsString.charAt(i);
            if (Character.isDigit(currentChar)) {
                decimalNumber = currentChar - '0';
            } else {
                decimalNumber = currentChar - 'A' + 10;
            }
            result += decimalNumber * binaryExponentiation(fromBase, j);
        }
        return result;
    }

    public static String convertDecToBase(int decimalNumber, int base) {
        var sb = new StringBuilder();
        while (decimalNumber > 0) {
            var remainder = decimalNumber % base;
            char digit = (char) (remainder < 10 ? (char)remainder + '0' : (char)(remainder - 10) + 'A');
            sb.append(digit);
            decimalNumber /= base;
        }
        return sb.reverse().toString();
    }
}
