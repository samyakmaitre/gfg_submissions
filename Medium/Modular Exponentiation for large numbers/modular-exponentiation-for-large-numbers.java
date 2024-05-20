//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String s = br.readLine();
            String[] S = s.split(" ");
            long x = Long.parseLong(S[0]);
            long n = Long.parseLong(S[1]);
            long m = Long.parseLong(S[2]);
            Solution ob = new Solution();
            long ans = ob.PowMod(x, n, m);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


//User function Template for Java
class Solution
{
    public long PowMod(long x, long n, long m)
    {
        // Ensure the base is within the modulus to simplify calculations
        x = x % m;
        
        // Initialize the result to 1
        long result = 1;

        // Loop until n becomes zero
        while (n > 0)
        {
            // If n is odd, multiply the result with x and take modulo m
            if ((n % 2) == 1)
            {
                result = (result * x) % m;
            }

            // Square x and reduce n by half
            x = (x * x) % m;
            n = n / 2;
        }

        return result;
    }
}
