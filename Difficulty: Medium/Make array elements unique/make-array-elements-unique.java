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
            int A = obj.minIncrements(a);
            System.out.println(A);
        }
    }
}
// } Driver Code Ends


// User function Template for Java



// User function Template for Java

class Solution {
    public int minIncrements(int[] arr) {
        // Code here
        
        
        int n=arr.length;
        Arrays.sort(arr);
        int ans=0;
        for(int x=1;x<n;x++){
            if(arr[x]<=arr[x-1]){
                ans+=(arr[x-1]-arr[x])+1;
                arr[x]=arr[x-1]+1;
            }
        }
        return ans;
        
    }
}