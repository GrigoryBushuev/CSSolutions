package Sorting;
public class BottomUpMergeSort {
    private static void merge(Comparable[] arr, Comparable[] aux, int lo, int mid, int hi) {
        var loIndex = lo;
        var midIndex = mid;

        if (hi - lo <= 1) {
            return;
        }

        for (var i = lo; i < hi; i++) {
            aux[i] = arr[i];
        }


        for (var j = lo; j < hi; j++) {
            if (loIndex >= mid) {
                arr[j] = aux[midIndex++];
            } else if (midIndex >= hi) {
                arr[j] = aux[loIndex++];
            } else if (aux[loIndex].compareTo(aux[midIndex]) < 0) {
                arr[j] = aux[loIndex++];
            } else {
                arr[j] = aux[midIndex++];
            }
        }
    }

    public static void sort(Comparable[] arr) {
        if (arr.length == 0 || arr.length == 1) {
            return;
        }
        var aux = new Comparable[arr.length];
        for (var sz = 1; sz < arr.length; sz <<= 1) {
            for (var lo = 0; lo < arr.length; lo += sz << 1) {
                merge(arr, aux, lo, lo + sz, Math.min(lo + (sz << 1), arr.length));
            }
        }
    }
}
