package Primitives;

public class ReverseBits {
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
}
