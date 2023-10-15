package Recursion.Subproblems;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class TowersOfHanoiWithStackV2 {

    static class Tower {
        public final String name;
        public final Stack<Integer> disks = new Stack<>();
        Tower(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return this.name;
        }
    }


    public static ArrayList<String> getMoves(int numberOfDisks) {
        var result = new ArrayList<String>();
        var srcTower = new Tower("1");
        for (int i = numberOfDisks; i >= 1; i--) {
            srcTower.disks.push(i);
        }
        getMoves(numberOfDisks, srcTower, new Tower("2"), new Tower("3"), result);
        return result;
    }

    private static void getMoves(int numberOfDisks, Tower src, Tower aux, Tower tgt, List<String> moves) {
        if (numberOfDisks == 1) {
            var disk = src.disks.pop();
            tgt.disks.push(disk);
            moves.add(String.format("Move disk %d from %s to %s", disk, src, tgt));
            return;
        }
        getMoves(numberOfDisks - 1, src, tgt, aux, moves);
        getMoves(1, src, aux, tgt, moves);
        getMoves(numberOfDisks - 1, aux, src, tgt, moves);
    }
}
