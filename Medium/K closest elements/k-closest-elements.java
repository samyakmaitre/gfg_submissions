//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

public class GFG {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            inputLine = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine[0]);
            int[] arr = new int[n];
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }
            inputLine = br.readLine().trim().split(" ");
            int k = Integer.parseInt(inputLine[0]);
            int x = Integer.parseInt(inputLine[1]);

            int[] ans = new Solution().printKClosest(arr, n, k, x);
            for (int xx : ans) {
                System.out.print(xx + " ");
            }
            System.out.println();
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    int[] printKClosest(int[] arr, int n, int k, int x) {
        // code here
        int ans[] = new int[k]; int m=0;

        int l = findClosest(arr, 0, n-1, x); //logn
        int r = l+1;

        if(arr[l]==x)
        l--;

        while(l>=0 && r<n && m<k){ //O(k)
            if(x - arr[l] < arr[r]-x){
                ans[m++] = arr[l];
                l--;
            }
            else{
                ans[m++] = arr[r];
                r++;
            }
        }
        while(m<k && l>=0){
           ans[m++] = arr[l];
                l--; 
        }
        while(m<k && r<n){
            ans[m++] = arr[r];
                r++;
        }
        return ans;
    }
    int findClosest(int arr[], int low, int high, int x){
        while(low<=high){
            if(arr[high]<=x)
            return high;

            if(arr[low] >x)
            return low;

            int mid = low + (high-low)/2;

            if(arr[mid]<=x && arr[mid+1]>x)
            return mid;

            if(arr[mid] > x){
                high = mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return -1;
    }
}
