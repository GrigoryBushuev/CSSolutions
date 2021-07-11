package Sorting;

import java.util.concurrent.ThreadLocalRandom;

public class QuickSort {
    private static final int InsertionSortThreshhold = 20;

    private static void swap(Comparable[] arr, int lo, int hi) {
        var temp = arr[lo];
        arr[lo] = arr[hi];
        arr[hi] = temp;
    }

    private static int getPartitionIndex(Comparable[] arr, int lo, int hi) {
        var partitionIndex = ThreadLocalRandom.current().nextInt(lo, hi + 1);
        var partitionIndexValue = arr[partitionIndex];
        swap(arr, lo, partitionIndex);
        var left = lo;
        var right = hi + 1;
        while(true) {
            while (++left < hi && arr[left].compareTo(partitionIndexValue) < 0) { }
            while(--right > lo && arr[right].compareTo(partitionIndexValue) > 0) { }
            if (left>=right) {
                break;
            }
            swap(arr, left, right);
        }
        swap(arr, lo, right);
        return right;
    }

    public static void insertionSort(Comparable[] arr, int lo, int hi) {
        for (var i = lo + 1; i <= hi; i++) {
            for (var j = i; j > lo && arr[j-1].compareTo(arr[j]) > 0; j--) {
                swap(arr, j - 1, j);
            }
        }
    }

    public static void sort(Comparable[] arr) {
        if (arr == null) {
            throw new NullPointerException("arr");
        }
        if (arr.length < 2) {
            return;
        }
        sort(arr, 0, arr.length - 1);
    }

    public static void sort(Comparable[] arr, int lo, int hi) {
        if (lo >= hi) {
            return;
        }
        if (hi <= lo + InsertionSortThreshhold) {
            insertionSort(arr, lo, hi);
            return;
        }
        var partitionIndex = getPartitionIndex(arr, lo, hi);
        sort(arr, lo, partitionIndex - 1);
        sort(arr, partitionIndex + 1, hi);
    }
}
