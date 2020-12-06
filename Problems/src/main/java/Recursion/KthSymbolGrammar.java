package Recursion;

public class KthSymbolGrammar {

    public int getKthGrammar(int N, int K) {
        if (N == 1) {
            return 0;
        }
        if (N == 2) {
            return K == 1 ? 0 : 1;
        }
        var result = getKthGrammar(N - 1, (K + 1) / 2 );
        if (result == 0) {
            return (K + 1) % 2 == 0 ? 0 : 1;
        }
        return (K + 1) % 2 == 0 ? 1 : 0;
    }

    public static void main(String[] args) {
        var kthSymbolGrammar = new KthSymbolGrammar();
        System.out.println(kthSymbolGrammar.getKthGrammar(4, 1));
        System.out.println(kthSymbolGrammar.getKthGrammar(4, 2));
        System.out.println(kthSymbolGrammar.getKthGrammar(4, 3));
        System.out.println(kthSymbolGrammar.getKthGrammar(4, 4));
        System.out.println(kthSymbolGrammar.getKthGrammar(4, 5));
        System.out.println(kthSymbolGrammar.getKthGrammar(4, 6));
        System.out.println(kthSymbolGrammar.getKthGrammar(4, 7));
        System.out.println(kthSymbolGrammar.getKthGrammar(4, 8));
    }

    /*
    * 1 : 0
    * 2 : 0 * 1
    * 3 : 0 1 * 1 0
    * 4 : 0 1 1 0 * 1 0 0 1 | k(3, 2), k(2, 2/2) = 0 ? 1 : 0, k(1, 1 / 2)
    * 5 : 0 1 1 0 1 0 0 1 * 1 0 0 1 0 1 1 0
    * 6 : 0 1 1 0 1 0 0 1 1 0 0 1 0 1 1 0 * 1 0 0 1 0 1 1 0 0 1 1 0 1 0 0 1
    * */
}
