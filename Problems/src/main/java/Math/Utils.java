package Math;

public class Utils {
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

    /*2^17 = 2^8 * 2^8 * 2^1
    *
    * 1) result = a * 1 = a; a = a ^ 2; n = 8;
    * 2) result = a; a = a ^ 2 * a ^ 2 = a ^ 4; n = 4;
    * 3) result = a; a = a ^ 4 * a ^ 4 = a ^ 8; n = 2;
    * 4) result = a; a = a ^ 8 * a ^ 8 = a ^ 16; n = 1;
    * 5) return result * a; return a * a ^ 16;
    */
}
