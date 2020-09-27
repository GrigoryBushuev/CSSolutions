package Recursion;

public class GCD {

    private static int getGcd(int a, int b){
        if (a == b) {
            return a;
        }
        if (b > a) {
            return getGcd(a, b - a);
        }
        else {
            return getGcd(a - b, b);
        }
    }

    public static void main(String[] args) {
        System.out.println(getGcd(780, 840));
        System.out.println(getGcd(840, 960));
        System.out.println(getGcd(780, 960));
        System.out.println(getGcd(16457, 1638));
    }
}
