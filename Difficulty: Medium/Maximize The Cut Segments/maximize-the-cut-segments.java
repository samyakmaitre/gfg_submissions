//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class Driver
{
    public static void main(String args[])throws IOException
    {
        //reading input using BufferedReader class
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        
        //reading total testcases
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0)
        {
            //reading length of line segment
            int n = Integer.parseInt(read.readLine().trim());
            
            
            //reading 3 segment lengths
            String str[] = read.readLine().trim().split(" ");
            
            int x = Integer.parseInt(str[0]);
            int y = Integer.parseInt(str[1]);
            int z = Integer.parseInt(str[2]);
            
            
            //calling method maximizeCuts() of class Solution()
            //and printinting the result
            System.out.println(new Solution().maximizeCuts(n, x, y, z));
        }
    }
}

// } Driver Code Ends


//User function Template for Java


class Solution
{
    // Function to find the maximum number of cuts.
    public int maximizeCuts(int n, int x, int y, int z)
    {
        // Create a dp array to store the maximum cuts for every length from 0 to n.
        int[] dp = new int[n + 1];
        
        // Initialize the dp array.
        // If the length is 0, no cuts can be made, so dp[0] = 0.
        for (int i = 1; i <= n; i++) {
            dp[i] = Integer.MIN_VALUE;
        }
        
        // Iterate over each length from 1 to n.
        for (int i = 1; i <= n; i++) {
            // If it's possible to make a cut of length x, y or z, update dp[i].
            if (i >= x && dp[i - x] != Integer.MIN_VALUE) {
                dp[i] = Math.max(dp[i], dp[i - x] + 1);
            }
            if (i >= y && dp[i - y] != Integer.MIN_VALUE) {
                dp[i] = Math.max(dp[i], dp[i - y] + 1);
            }
            if (i >= z && dp[i - z] != Integer.MIN_VALUE) {
                dp[i] = Math.max(dp[i], dp[i - z] + 1);
            }
        }
        
        // If dp[n] is still Integer.MIN_VALUE, it means no cuts were possible.
        // In that case, return 0. Otherwise, return dp[n].
        return dp[n] == Integer.MIN_VALUE ? 0 : dp[n];
    }
}

