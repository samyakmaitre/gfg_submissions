//{ Driver Code Starts
import java.util.*;

class Maxsum_Among_All_Rotations_Array {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0) {
            int n = sc.nextInt();
            int arr[] = new int[n];
            for (int i = 0; i < n; i++) arr[i] = sc.nextInt();

            System.out.println(new Solution().max_sum(arr, n));

            t--;
        }
    }
}

// } Driver Code Ends


class Solution {
    long max_sum(int arr[], int n) {
        // Your code here
        long sum=0;
        long prev_sum=0;
        for(int i=0; i<n; i++){
            prev_sum +=  (long)i*arr[i];
            sum+=arr[i];
        }
        long ans=prev_sum;

        for(int i=1; i<n; i++){
            long curr_sum = prev_sum - (sum -arr[i-1]) + (long)arr[i-1]*(n-1);

            prev_sum = curr_sum;
          if(curr_sum > ans) ans = curr_sum;
        }
        return ans;
    }
} 
