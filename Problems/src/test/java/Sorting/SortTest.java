package Sorting;

import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

public class SortTest {

    @Test
    public void bottomUpMergeSort_returnsExpectedResult() {
        Integer[] inputParams = { -6, 3, 1, 2, -4, 7, 5 };
        var sut = new BottomUpMergeSort();
        sut.sort(inputParams);
        assertThat(inputParams)
                .isNotEmpty()
                .hasSize(7)
                .containsExactly(-6, -4, 1, 2, 3, 5, 7);
    }

    @Test
    public void insertionSort_returnsExpectedResult() {
        Integer[] inputParams = { -6, 3, 1, 2, -4, 7, 5 };
        var sut = new InsertionSort();
        sut.sort(inputParams);
        assertThat(inputParams)
                .isNotEmpty()
                .hasSize(7)
                .containsExactly(-6, -4, 1, 2, 3, 5, 7);
    }

    @Test
    public void quickSort_returnsExpectedResult() {
        Integer[] inputParams = { -74,48,-20,2,10,-84,-5,-9,11,-24,-91,2,-71,64,63,80,28,-30,-58,-11,-44,-87,-22,54,-74,-10,-55,-28,-46,29,10,50,-72,34,26,25,8,51,13,30,35,-8,50,65,-6,16,-2,21,-78,35,-13,14,23,-3,26,-90,86,25,-56,91,-13,92,-25,37,57,-20,-69,98,95,45,47,29,86,-28,73,-44,-46,65,-84,-96,-24,-12,72,-68,93,57,92,52,-45,-2,85,-63,56,55,12,-85,77,-39};
        var sut = new QuickSort();
        sut.sort(inputParams);
        assertThat(inputParams)
                .isNotEmpty()
                //.hasSize(9)
                //.containsExactly(1, 2, 3, 4, 5, 5);
                .containsExactly(-96,-91,-90,-87,-85,-84,-84,-78,-74,-74,-72,-71,-69,-68,-63,-58,-56,-55,-46,-46,-45,-44,-44,-39,-30,-28,-28,-25,-24,-24,-22,-20,-20,-13,-13,-12,-11,-10,-9,-8,-6,-5,-3,-2,-2,2,2,8,10,10,11,12,13,14,16,21,23,25,25,26,26,28,29,29,30,34,35,35,37,45,47,48,50,50,51,52,54,55,56,57,57,63,64,65,65,72,73,77,80,85,86,86,91,92,92,93,95,98);
    }

    @Test
    public void countingSort_returnsExpectedResult() {
        var sut = new CountingSort();
        int[] inputParams = { 0,1,2,1,2,2,2,1,0 };
        sut.sort(inputParams);
        assertThat(inputParams)
                .isNotEmpty()
                .containsExactly(0,0,1,1,1,2,2,2,2);

        inputParams = new int[]{ 2, 0, 2, 1, 1, 0 };
        sut.sort(inputParams);
        assertThat(inputParams)
                .isNotEmpty()
                .containsExactly(0, 0, 1, 1, 2, 2);

        inputParams = new int[]{ 2, 0, 1 };
        sut.sort(inputParams);
        assertThat(inputParams)
                .isNotEmpty()
                .containsExactly(0, 1, 2);

        inputParams = new int[]{ 0, 0 };
        sut.sort(inputParams);
        assertThat(inputParams)
                .isNotEmpty()
                .containsExactly(0, 0);

        inputParams = new int[]{ 0 };
        sut.sort(inputParams);
        assertThat(inputParams)
                .isNotEmpty()
                .containsExactly(0 );

        inputParams = new int[]{ 6, 7, 0, 9, 5, 1, 7, 0, -3, -1 };
        sut.sort(inputParams);
        assertThat(inputParams)
                .isNotEmpty()
                .containsExactly(-3, -1, 0, 0, 1, 5, 6, 7, 7, 9);
    }

    @Test
    public void threePartitionSort_returnsExpectedResult() {
        var sut = new ThreePartitionSort();
        int[] inputParams = { 0,1,2,1,2,2,2,1,0 };
        sut.sort(inputParams);
        assertThat(inputParams)
                .isNotEmpty()
                .containsExactly(0,0,1,1,1,2,2,2,2);

        inputParams = new int[]{ 2, 0, 2, 1, 1, 0 };
        sut.sort(inputParams);
        assertThat(inputParams)
                .isNotEmpty()
                .containsExactly(0, 0, 1, 1, 2, 2);

        inputParams = new int[]{ 2, 0, 1 };
        sut.sort(inputParams);
        assertThat(inputParams)
                .isNotEmpty()
                .containsExactly(0, 1, 2);

        inputParams = new int[]{ 0, 0 };
        sut.sort(inputParams);
        assertThat(inputParams)
                .isNotEmpty()
                .containsExactly(0, 0);

        inputParams = new int[]{ 0 };
        sut.sort(inputParams);
        assertThat(inputParams)
                .isNotEmpty()
                .containsExactly(0 );
    }

    @Test
    public void radixSort_returnsExpectedResult() {
        var sut = new RadixSort();
        int[] inputParams = { 329, -1, 457, -100, 657, 839, 436, 720, -55, -32, 355 };
        sut.sort(inputParams);
        assertThat(inputParams)
                .isNotEmpty()
                .containsExactly(-100, -55, -32, -1, 329, 355, 436, 457, 657, 720, 839 );
    }
}