package src.AmzOA;

import java.util.Arrays;

public class SplitStringIntoPrimes {

    // Time Complexity: O(N + N*log(log(N)))
    // Auxiliary Space: O(N)

    static int MOD = 1000000007;
    static boolean[] precomputedPrimes = new boolean[1000000];

    // Function to build sieve
    static void precomputePrimeValues() {
        Arrays.fill(precomputedPrimes, true);

        precomputedPrimes[0] = false;
        precomputedPrimes[1] = false;

        for (int ele = 2; ele * ele <= 1000000; ele++) {

            // If p is a prime
            if (precomputedPrimes[ele] == true) {

                // Update all multiple of p as non prime
                for (int i = ele * ele; i < 1000000;
                     i += ele)
                    precomputedPrimes[i] = false;
            }
        }
    }

    // Function to check whether a number is a prime number or not
    static boolean isValidPrime(String number) {
        int num = Integer.valueOf(number);
        return precomputedPrimes[num];
    }

    // Function to find the count of ways to split String into prime numbers
    static int countWays(String currNumber, int i,
                         int[] dp) {
        if (dp[i] != -1)
            return dp[i];
        int cnt = 0;

        // Consider every suffix up to 6 digits
        for (int j = 1; j <= 6; j++) {

            // Number should not have leading zero and should be a prime number
            if (i - j >= 0 &&
                    currNumber.charAt(i - j) != '0' &&
                    isValidPrime(currNumber.substring(i - j, i))) {
                cnt += countWays(currNumber, i - j, dp);
                cnt %= MOD;
            }
        }
        return dp[i] = cnt;
    }

    // Function to count the number of prime Strings
    static int countPrimeStrings(String number) {
        int n = number.length();
        int[] primeDP = new int[n + 1];

        Arrays.fill(primeDP, -1);
        primeDP[0] = 1;

        return countWays(number, n, primeDP);
    }

    // Driver code
    public static void main(String[] args) {
        precomputePrimeValues();
        String s1 = "31173";
        System.out.print(countPrimeStrings(s1) + "\n");
    }
}
