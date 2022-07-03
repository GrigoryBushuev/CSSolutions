package BinarySearch;

import java.util.Optional;

public class BinarySearch {
    public static int findIndex(int[] sortedArray, int target, Optional<Integer> excludingIndexOptional) {
        var excludingIndex = excludingIndexOptional.isPresent() ? excludingIndexOptional.get() : -1;
        var start = 0;
        var end = sortedArray.length - 1;
        var searchIndex = 0;
        while (start <= end) {
            searchIndex = start + (end - start) / 2;
            if (searchIndex == excludingIndex) {
                if (searchIndex + 1 < sortedArray.length) {
                    searchIndex++;
                } else {
                    searchIndex--;
                }
            }
            var searchIndexValue = sortedArray[searchIndex];
            if (searchIndexValue == target) {
                return searchIndex;
            } else if (searchIndexValue < target) {
                start = searchIndex + 1;
            } else {
                end = searchIndex - 1;
            }
        }
        return -1;
    }
}
