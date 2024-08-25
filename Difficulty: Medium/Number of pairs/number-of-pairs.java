//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int g = 0; g < t; g++) {
            String[] str = (br.readLine()).trim().split(" ");
            int x[] = new int[str.length];
            for (int i = 0; i < str.length; i++) x[i] = Integer.parseInt(str[i]);
            str = (br.readLine()).trim().split(" ");
            int[] y = new int[str.length];
            for (int i = 0; i < str.length; i++) {
                y[i] = Integer.parseInt(str[i]);
            }
            System.out.println(new Solution().countPairs(x, y, x.length, y.length));
        }
    }
}

// } Driver Code Ends


//Back-end complete function Template for Java
class Solution {
    // Function to count number of pairs such that x^y is greater than y^x.
    public long countPairs(int x[], int y[], int M, int N) {
        // Sort array y[] so that we can use binary search on it.
        Arrays.sort(y);
        
        // Precompute counts of specific values in y[] array.
        int[] countOfY = new int[5];
        for (int i = 0; i < N; i++) {
            if (y[i] < 5) {
                countOfY[y[i]]++;
            }
        }
        
        long totalPairs = 0;
        
        // Iterate over all elements in array x[].
        for (int i = 0; i < M; i++) {
            totalPairs += countValidPairs(x[i], y, N, countOfY);
        }
        
        return totalPairs;
    }

    // Helper function to count the number of valid pairs for a given x.
    private long countValidPairs(int x, int[] y, int N, int[] countOfY) {
        // If x is 0, there are no valid pairs because 0^y is always 0.
        if (x == 0) return 0;

        // If x is 1, we can only form pairs with y = 0.
        if (x == 1) return countOfY[0];

        // Find the index where y[i] > x using binary search.
        int index = Arrays.binarySearch(y, x);
        if (index < 0) {
            index = -(index + 1);
        } else {
            while (index < N && y[index] == x) {
                index++;
            }
        }
        
        long validPairs = N - index; // All y > x will form a valid pair.
        
        // Special cases:
        // 1. If x == 2, it can form pairs with y == 3 and y == 4 (where 2^3 > 3^2 and 2^4 > 4^2).
        validPairs += countOfY[1] + countOfY[0];
        
        // 2. If x == 3, the pair (3, 2) is valid but (3, 3) is not.
        if (x == 2) {
            validPairs -= (countOfY[3] + countOfY[4]);
        }
        
        // 3. If x == 3, it can form pairs with y == 2 (where 3^2 > 2^3).
        if (x == 3) {
            validPairs += countOfY[2];
        }

        return validPairs;
    }
}