//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            String arr[] = br.readLine().split(" ");
            int a[] = new int[arr.length];

            for (int i = 0; i < arr.length; i++) {
                a[i] = Integer.parseInt(arr[i]);
            }
            Solution obj = new Solution();
            int f = 0;
            int idx = obj.peakElement(a);
            int n = a.length;
            if (idx < 0 && idx >= n)
                System.out.println("false");
            else {
                if (n == 1 && idx == 0)
                    f = 1;
                else if (idx == 0 && a[0] > a[1])
                    f = 1;
                else if (idx == n - 1 && a[n - 1] > a[n - 2])
                    f = 1;
                else if (idx > 0 && idx < n && a[idx] > a[idx + 1] &&
                         a[idx] > a[idx - 1])
                    f = 1;
                else
                    f = 0;
                if (f == 1) {
                    System.out.println("true");
                } else {
                    System.out.println("false");
                }
            }
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


class Solution {

    public int peakElement(int[] arr) {
        int n = arr.length;
        
        for (int i = 0; i < n; i++) {
            if (isPeak(arr, i)) {
                return i; // Return the index of the peak element
            }
        }
        
        return -1; // No peak element found (though this case should not occur)
    }
    
    static boolean isPeak(int[] arr, int i) {
        int n = arr.length;
        if(n==1) return true;
        // Check the first element
        if (i == 0) {
            return arr[0] >= arr[1];
        }
        
        // Check the last element
        if (i == n - 1) {
            return arr[n - 1] >= arr[n - 2];
        }
        
        // Check the middle elements
        return arr[i] >= arr[i - 1] && arr[i] >= arr[i + 1];
    }
}

