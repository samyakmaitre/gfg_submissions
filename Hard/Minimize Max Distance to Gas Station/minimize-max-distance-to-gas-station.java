//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.math.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int a[] = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }
            int k = sc.nextInt();
            Solution obj = new Solution();
            double ans = obj.findSmallestMaxDist(a, k);
            System.out.printf("%.2f", ans);
            System.out.println();
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public static double findSmallestMaxDist(int stations[], int k) {
        int n = stations.length;
        double low = 0;
        double high = stations[n - 1] - stations[0];
        
        while (high - low > 1e-6) {
            double mid = (low + high) / 2;
            if (canPlaceStations(stations, k, mid)) {
                high = mid;
            } else {
                low = mid;
            }
        }
        
        return Math.round(high * 100.0) / 100.0;
    }
    
    private static boolean canPlaceStations(int[] stations, int k, double d) {
        int count = 0;
        for (int i = 1; i < stations.length; i++) {
            count += Math.floor((stations[i] - stations[i - 1]) / d);
        }
        return count <= k;
    }
}
