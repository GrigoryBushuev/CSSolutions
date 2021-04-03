package Arrays;

/*Given an array nums of integers, return how many of them contain an even number of digits.*/
public class EvenNumberOfDigitsFinder {

    public int findNumbers(int[] nums) {
        int result = 0;
        for (int number : nums) {
            if (isEven(getNumberOfDigits(number))) {
                result++;
            }
        }
        return result;
    }

    public static boolean isEven(int number) {
        return number % 2 == 0;
    }

    public static int getNumberOfDigits(int number) {
        number = Math.abs(number);
        if (number >= 100_000) {
            if (number >= 10_000_000) {
                if (number >= 1_000_000_000) {
                    return 10;
                } else if (number >= 100_000_000) {
                    return 9;
                }
                return 8;
            } else {
                if (number >= 1_000_000) {
                    return 7;
                } else {
                    return 6;
                }
            }
        } else {
            if  (number >= 1_000) {
                if (number >= 10_000) {
                    return 5;
                } else {
                    return 4;
                }
            } else {
                if (number >= 100) {
                    return 3;
                } else if (number >= 10) {
                    return 2;
                }
                return 1;
            }
        }
    }
}
