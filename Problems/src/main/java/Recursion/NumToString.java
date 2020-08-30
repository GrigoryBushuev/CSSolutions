package Recursion;

public class NumToString {
    /**
     * @param n integer to convert to string
     * @param base base for the representation. Requires 2<=base<=10.
     * @return n represented as a string of digits in the specified base, with
     *           a minus sign if n<0.  No unnecessary leading zeros are included.
     */
    public static String numToString(int n, int base) {
        if (n < 0) {
            return "-" + numToString(-n, base);
        } else if (n < base) {
            return String.valueOf("0123456789".charAt(n));
        } else {
            return numToString(n/base, base) + "0123456789".charAt(n%base);
        }
    }

    public static void main(String[] args){
        System.out.println(numToString(16, 10));
        System.out.println(numToString(3, 10));
        System.out.println(numToString(0, 10));
    }
}
