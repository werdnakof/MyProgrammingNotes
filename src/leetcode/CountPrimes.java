package leetcode;

import java.util.Arrays;
import java.util.HashMap;

public class CountPrimes {


    /**
     * Sieve of Eratosthenes
     * https://www.youtube.com/watch?v=eKp56OLhoQs
     *
     * O(N * sqrt(N)) time
     * O(N) space
     *
     * @param n
     * @return
     */
    public static int countPrimes(int n) {
        boolean[] primes = new boolean[n]; // assume all are not not primes
        Arrays.fill(primes, true);

        Boolean isPrime;
        int current = 2, count = 0;

        while(current < n) {
            isPrime = primes[current];

            // is current is a prime
            // 1. increment count
            // 2. multiples of current are all not primes now
            if(isPrime) {
                count++;
                for(int j = 2; j*current < n; j++) primes[j*current] = false;
            }

            current++;
        }

        return count;
    }

    public static void main(String[] args) {
        System.out.println(countPrimes(20));
    }
}
