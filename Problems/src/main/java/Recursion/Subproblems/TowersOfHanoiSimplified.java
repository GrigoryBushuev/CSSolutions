package Recursion.Subproblems;

public class TowersOfHanoiSimplified {

    public static void move(int numberOfDisks, int src, int aux, int tgt) {
        if (numberOfDisks == 1) {
            System.out.println(String.format("%d -> %d", src, tgt));
            return;
        }

        move(numberOfDisks - 1, src, tgt, aux);
        move(1, src, aux, tgt);
        move(numberOfDisks - 1, aux, src, tgt);
    }

    public static void main(String ...args) {
        move(4, 1, 2, 3);
    }

}
