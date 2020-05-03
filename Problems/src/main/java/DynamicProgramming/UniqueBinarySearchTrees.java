package DynamicProgramming;

public class UniqueBinarySearchTrees {
    public static int numTrees(int n) {
        if ( n < 2) {
            return n;
        }
        if (n == 2) {
            return 2;
        }
//        if (n == 3) {
//            return 5;
//        }
        int result = 0;
//        for (int i = 01 i < n; i++ ) {
//            result += numTrees(n - i) * numTrees (n - i - 1);
//        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println( numTrees(3));
    }
}
