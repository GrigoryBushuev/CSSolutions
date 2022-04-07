package BitManipulation;
import Math.*;


public class BitManipulation {
	public static String toBinaryString(int n) {
		var buf = new char[32];
		for (var i = 31; i >= 0; i--) {
			buf[i] = (n & 1) == 1 ? '1' : '0';
			n >>>= 1;
		}
		return new String(buf);
	}

	public static long parseLong(String binaryString, int radix) throws NumberFormatException {
		//null check
		//length check

		//return Long.parseLong(binaryString, 2);
		long result = 0;
		var len = binaryString.length();
		var exponent = 0;
		for (var i = len - 1; i >= 0; i--){
			var val = binaryString.charAt(i);
			result += Character.getNumericValue(val) * Utils.binaryExponentiation(radix, exponent++);
		}
		return result;
	}

	public static int getBitsCount(int n) {
		int result = 0;
		while (n > 0) {
			if ((n & 1) == 1) {
				result++;
			}
			n >>= 1;
		}
		return result;
	}

	public int reverseBits(int input) {
		var result = 0;
		for (var i = 31; i >=0; i--) {
			if ((input & 1) == 1) {
				result |= (1 << i);
			}
			input >>= 1;
		}
		return result;
	}

	public static int reverseBitsWithoutIterations(int input) {
		var swappedAdjacentBits = swapAdjacentBits(input);
		var swappedPairs = swapPairs(swappedAdjacentBits);
		var swappedQuaters = swapQuaters(swappedPairs);
		return swapEndianness(swappedQuaters);
	}

	public static int swapEndianness(int n) {
		var firstByte = (n & 0x000000FF) << 24;
		var secondByte = (n & 0x0000FF00) << 8;
		var thirdByte = (n & 0x00FF0000) >>> 8;
		var fourthByte = (n & 0xFF000000) >>> 24;

		return firstByte | secondByte | thirdByte | fourthByte;
	}

	public static int swapAdjacentBits(int n) {
		return ((n & 0xAAAAAAAA) >>> 1) | ((n & 0x55555555) << 1);
	}

	public static int swapPairs(int n) {
		return ((n & 0xCCCCCCCC) >>> 2) | ((n & 0x33333333) << 2);
	}

	public static int swapQuaters(int n) {
		return ((n & 0xF0F0F0F0) >>> 4) | ((n & 0x0F0F0F0F) << 4);
	}
}

