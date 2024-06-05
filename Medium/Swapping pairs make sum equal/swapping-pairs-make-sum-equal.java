//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;


// } Driver Code Ends
// User function Template for Java

import java.util.HashSet;

class Solution {
    long findSwapValues(long a[], int n, long b[], int m) {
        // Calculate the sums of both arrays
        long sumA = 0, sumB = 0;
        for (int i = 0; i < n; i++) {
            sumA += a[i];
        }
        for (int i = 0; i < m; i++) {
            sumB += b[i];
        }

        // Calculate the difference between sums
        long diff = sumA - sumB;

        // If the difference is odd, no valid swap can make the sums equal
        if (diff % 2 != 0) {
            return -1;
        }

        // The target difference we need to find
        diff /= 2;

        // Use a set for quick lookup
        HashSet<Long> setA = new HashSet<>();
        for (int i = 0; i < n; i++) {
            setA.add(a[i]);
        }

        // Check for each element in b[] if there's a corresponding element in a[] 
        // that satisfies the condition a[i] - b[j] = diff
        for (int i = 0; i < m; i++) {
            if (setA.contains(b[i] + diff)) {
                return 1;
            }
        }

        // If no such pair is found, return -1
        return -1;
    }
}



//{ Driver Code Starts.

// Driver class
class Array {

    // Driver code
    public static void main(String[] args) throws IOException {
        // Taking input using buffered reader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testcases = Integer.parseInt(br.readLine());
        // looping through all testcases
        while (testcases-- > 0) {
            String line = br.readLine();
            String[] q = line.trim().split("\\s+");
            int n = Integer.parseInt(q[0]);
            int m = Integer.parseInt(q[1]);
            String line1 = br.readLine();
            String[] a1 = line1.trim().split("\\s+");
            long a[] = new long[n];
            for (int i = 0; i < n; i++) {
                a[i] = Long.parseLong(a1[i]);
            }
            String line2 = br.readLine();
            String[] a2 = line2.trim().split("\\s+");
            long b[] = new long[m];
            for (int i = 0; i < m; i++) {
                b[i] = Long.parseLong(a2[i]);
            }
            Solution ob = new Solution();
            long ans = ob.findSwapValues(a, n, b, m);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends