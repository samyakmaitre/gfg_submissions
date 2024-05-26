//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GfG {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            String X = sc.next();
            String Y = sc.next();
            int costX = sc.nextInt();
            int costY = sc.nextInt();

            Solution ob = new Solution();
            System.out.println(ob.findMinCost(X, Y, costX, costY));
        }
    }
}
// } Driver Code Ends


class Solution {
    public int findMinCost(String x, String y, int costX, int costY) {
        int m = x.length();
        int n = y.length();
        
        // Create a 2D DP array
        int[][] dp = new int[m + 1][n + 1];
        
        // Initialize the first row and column
        for (int i = 1; i <= m; i++) {
            dp[i][0] = i * costX;  // Cost of deleting all characters from x[0:i]
        }
        for (int j = 1; j <= n; j++) {
            dp[0][j] = j * costY;  // Cost of deleting all characters from y[0:j]
        }
        
        // Fill the DP array
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (x.charAt(i - 1) == y.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];  // No cost if characters match
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j] + costX, dp[i][j - 1] + costY);  // Min cost of deleting a character
                }
            }
        }
        
        return dp[m][n];  // The minimum cost to make x and y identical
    }
}

