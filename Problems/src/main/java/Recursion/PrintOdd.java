package Recursion;

public class PrintOdd {
    	/*private static<T> void printOdd(T[] arr, int index) {
	   	if (index == arr.length){
	        		return;
	    	}
		if (index % 2 == 1) {
			System.out.println(arr[index]);
        		}
        		printOdd(arr, index + 1);
    	}*/

    private static <T> void printOdd(T[] arr, int index) {
        if (index >= arr.length) {
            return;
        }

        System.out.println(arr[index]);
        printOdd(arr, index + 2);
    }

    public static <T> void printOdd(T[] arr) {
        printOdd(arr, 0);
    }

    public static void main(String[] args) {
        printOdd(new Integer[]{ 0, 1, 2, 3, 4, 5 });
    }
}