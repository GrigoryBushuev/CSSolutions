package Recursion.Subproblems;

/*
Write a function that computes the Greatest Common Divisor (GCD) of two
numbers.

Euclid’s Algorithm:
gcd(a, b) = gcd(b, a % b)
gcd(a, 0) = a
For any a > b
*/
public class GCD {

    private static int getGcd(int a, int b){
        if (b == 0) {
            return a;
        }
        return getGcd(b, a % b);
    }

    public static void main(String[] args) {
        System.out.println(getGcd(780, 840));
        System.out.println(getGcd(840, 960));
        System.out.println(getGcd(780, 960));
        System.out.println(getGcd(16457, 1638));
    }
}
