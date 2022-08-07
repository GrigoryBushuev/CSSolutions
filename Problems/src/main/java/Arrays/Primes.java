package Arrays;
import java.util.*;

/*Given an integer n, return the number of prime numbers that are strictly less than n.*/
public class Primes {
    public int countPrimes(int n) {
        var result = new ArrayList<Integer>();
        if (n < 2) {
            return 0;
        }
        var sieve = new boolean[n];
        for (var i = 0; i < n; i++) {
            sieve[i] = true;
        }
        for (var i = 2; i * i < n; i++) {
            if (!sieve[i]) {
                continue;
            }
            for (var j = i * i; j < n; j += i) {
                sieve[j] = false;
            }
        }

        for (var i = 2; i < n; i++) {
            if (sieve[i]) {
                result.add(i);
            }
        }
        return result.size();
    }
}
