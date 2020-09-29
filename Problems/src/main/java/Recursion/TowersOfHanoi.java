package Recursion;

import java.util.List;

public class TowersOfHanoi {

    private class Move {
        private final int index;
        private final int source;
        private final int destination;

        public Move(int index, int source, int destination){
            this.index = index;
            this.source = source;
            this.destination = destination;
        }

        public int getIndex() {
            return index;
        }

        public int getSource() {
            return source;
        }

        public int getDestination() {
            return destination;
        }
    }

    public static List<Move> getMoves(int n) {
        return null;
    }

    public static void main(String[] args) {

    }
}
