package Recursion;

public class MinMax {
    private class Pair<X, Y> {
        private X x;
        private Y y;

        public Pair(X x, Y y) {
            this.x = x;
            this.y = y;
        }

        public X getX() {
            return this.x;
        }

        public void setX(X x) {
            this.x = x;
        }

        public Y getY() {
            return this.y;
        }

        public void setY(Y y) {
            this.y = y;
        }
    }

    private <T extends Comparable<T>> void getMinMax(T[] arr, Pair<T, T> result, int index) {
        if (arr.length == index) {
            return;
        }
        if (arr[index].compareTo(result.y) > 0) {
            result.setY(arr[index]);
        }
        if (arr[index].compareTo(result.x) < 0) {
            result.setX(arr[index]);
        }
        getMinMax(arr, result, index + 1);
    }

    public <T extends Comparable<T>> Pair<T, T> getMinMax(T[] arr) throws Exception {
        if (arr ==  null) {
            throw new IllegalArgumentException("arr is null");
        }
        if (arr.length == 0) {
            throw new IllegalArgumentException("Length of arr is 0");
        }

        Pair<T, T> result = new Pair<T, T>(arr[0], arr[0]);
        getMinMax(arr, result, 1);
        return result;
    }

    public static void main(String[] args) throws Exception {
        Pair<Integer, Integer> result = (new MinMax()).getMinMax(new Integer[] { 0,4,6,2,8,1,11,3});
        System.out.println(result.getX() + ";" +result.getY());
    }
}

