//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N = Integer.parseInt(read.readLine());

            Solution ob = new Solution();
            System.out.println(ob.numberOfConsecutiveOnes(N));
        }
    }
}
// } Driver Code Ends


// User function Template for Java
class Solution {
    static int MOD = (int)1e9 + 7;

    static long modExp(long base, int exp, int mod) {
        long result = 1;
        while (exp > 0) {
            if ((exp & 1) == 1) {
                result = (result * base) % mod;
            }
            base = (base * base) % mod;
            exp >>= 1;
        }
        return result;
    }

    static int numberOfConsecutiveOnes(int n) {
        if (n == 1) return 0; // No strings of length 1 can have consecutive 1s

        // Arrays to store the number of valid strings ending with 0 and 1
        int[] dp0 = new int[n + 1];
        int[] dp1 = new int[n + 1];

        dp0[1] = 1; // "0"
        dp1[1] = 1; // "1"

        // Fill the dp arrays
        for (int i = 2; i <= n; i++) {
            dp0[i] = (dp0[i - 1] + dp1[i - 1]) % MOD;
            dp1[i] = dp0[i - 1];
        }

        // Total valid strings without consecutive 1's
        int validStrings = (dp0[n] + dp1[n]) % MOD;

        // Total binary strings of length n
        long totalStrings = modExp(2, n, MOD);

        // Result: total strings - valid strings
        int result = (int)((totalStrings - validStrings + MOD) % MOD);

        return result;
    }
}

