package Sorting;

public class InsertionSort {
    private static void swap(Comparable[] arr, int i, int j) {
        var temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void sort(Comparable[] arr) {
        if (arr.length <= 1) {
            return;
        }

        for (var i = 1; i < arr.length; i++) {
            for (var j = i; j > 0 && arr[j].compareTo(arr[j-1]) < 0;j--) {
                swap(arr, j - 1, j);
            }
        }

    }
}
