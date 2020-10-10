package Recursion;

import java.util.*;

public class TowersOfHanoi {

    private static class Move {
        private final int index;
        private final String source;
        private final String destination;

        public Move(final int index, String source, String destination){
            this.index = index;
            this.source = source;
            this.destination = destination;
        }

        @Override
        public String toString() {
            return "Move " +
                    "disk=" + index +
                    " from=" + source +
                    " to=" + destination;
        }
    }

    private static class Peg
    {
        public final String name;
        public final Stack<Integer> peg;
        public Peg(String name){
            this.name = name;
            this.peg = new Stack<>();
        }

    }

    private static Move getMoveFromTop(Peg start, Peg dest, int n) {
        var top = start.peg.pop();
        dest.peg.push(top);
        return new Move(n, start.name, dest.name);
    }

    public static List<Move> getMoves(Peg start, Peg aux, Peg dest, int n) {
        if (n == 0){
            return new ArrayList<>();
        }
        var result = new ArrayList<Move>();
        result.addAll(getMoves(start, dest, aux, n - 1));
        result.add(getMoveFromTop(start, dest, n));
        result.addAll(getMoves(aux, start, dest, n- 1));
        return result;
    }

    public static void main(String[] args) {
        var startTower = new Peg("start");
        var auxTower = new Peg("aux");
        var destTower = new Peg("dest");

        final int height = 3;
        for (var i = height - 1; i >= 0;  i--) {
            startTower.peg.push(i);
        }

        for (var move : getMoves(startTower, auxTower, destTower, height)){
            System.out.println(move);
        }
    }
}
