//{ Driver Code Starts
import java.util.*;

class GFG {
    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while (T > 0) {
            int N = sc.nextInt();
            int k = sc.nextInt();
            int ar[] = new int[N];
            //	int count = 0;
            for (int i = 0; i < N; i++) ar[i] = sc.nextInt();

            System.out.println(new Solution().max_Books(ar, N, k));
            T--;
        }
    }
}
// } Driver Code Ends



class Solution {
    long max_Books(int arr[], int n, int k) {
        long maxBooks = 0;  // Variable to store the maximum books we can collect
        long currentSum = 0; // Variable to store the sum of the current valid window

        for (int i = 0; i < n; i++) {
            if (arr[i] <= k) {
                // Add the current stack to the current valid window
                currentSum += arr[i];
                // Update the maximum books collected
                maxBooks = Math.max(maxBooks, currentSum);
            } else {
                // Reset the current sum if we hit a stack taller than k
                currentSum = 0;
            }
        }

        return maxBooks;
    }
}
