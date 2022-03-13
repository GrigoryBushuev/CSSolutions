package Primitives;

public class PalindromeCheck {
    public boolean isPalindrome(int x){
        if (x < 0) {
            return false;
        }
        var totalNums = ((int)Math.floor(Math.log10(x)) + 1);
        if (totalNums == 1) {
            return true;
        }
        var mask = (int)Math.pow(10, totalNums - 1);
        for (var i = 0; i < totalNums / 2; i++) {
            var firstDigit = x / mask;
            var lastDigit = x % 10;
            if (firstDigit != lastDigit) {
                return false;
            }
            mask = mask / 10;
            x = x / 10;
            x = x % mask;
            mask = mask / 10;
        }
        return true;
    }
}
