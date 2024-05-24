//{ Driver Code Starts
import java.io.*;
import java.util.*;


class IntArray
{
    public static int[] input(BufferedReader br, int n) throws IOException
    {
        String[] s = br.readLine().trim().split(" ");
        int[] a = new int[n];
        for(int i = 0; i < n; i++)
            a[i] = Integer.parseInt(s[i]);

        return a;
    }

    public static void print(int[] a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }

    public static void print(ArrayList<Integer> a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            
            int n;
            n = Integer.parseInt(br.readLine());
            
            
            int d;
            d = Integer.parseInt(br.readLine());
            
            
            int[] arr = IntArray.input(br, n);
            
            Solution obj = new Solution();
            int res = obj.countPartitions(n, d, arr);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends


class Solution {
    public static int countPartitions(int n, int d, int[] arr) {
        // Calculate the total sum of the array
        int sum_total = 0;
        for (int num : arr) {
            sum_total += num;
        }
        
        // Check if the required sum for one subset is an integer
        if ((sum_total + d) % 2 != 0) {
            return 0;
        }
        
        // Calculate the target sum for the subset
        int target = (sum_total + d) / 2;
        
        // If the target sum is negative or larger than sum_total, it's not possible
        if (target < 0 || target > sum_total) {
            return 0;
        }
        
        // DP array to store the count of subsets for each possible sum
        int[] dp = new int[target + 1];
        dp[0] = 1; // There's one way to make sum 0, by taking no elements
        
        // Iterate through each number in the array
        for (int num : arr) {
            for (int j = target; j >= num; j--) {
                dp[j] = (dp[j] + dp[j - num]) % 1000000007;
            }
        }
        
        return dp[target];
    }
}

        
