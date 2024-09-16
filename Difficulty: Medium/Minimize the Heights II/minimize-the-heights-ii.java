//{ Driver Code Starts
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            inputLine = br.readLine().trim().split(" ");
            int k = Integer.parseInt(inputLine[0]);

            // Ensure input is read correctly
            inputLine = br.readLine().trim().split(" ");
            if (inputLine == null || inputLine.length == 0) {
                System.out.println("Invalid input");
                continue;
            }

            int[] arr = new int[inputLine.length];
            for (int i = 0; i < inputLine.length; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            int ans = new Solution().getMinDiff(arr, k);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    int getMinDiff(int[] arr, int k) {
        int n = arr.length;
        if (n == 1) {
            return 0; // Only one tower, no difference to minimize.
        }
        
        // Sort the array
        Arrays.sort(arr);
        
        // Initialize result with the current difference between the highest and lowest towers
        int diff = arr[n - 1] - arr[0];
        
        // The smallest and largest after the first operation
        int smallest = arr[0] + k;
        int largest = arr[n - 1] - k;
        
        // Traverse the array and adjust the heights
        for (int i = 0; i < n - 1; i++) {
            int minVal = Math.min(smallest, arr[i+1] - k);
            int maxVal = Math.max(largest, arr[i] + k);
            
            // Ignore cases that would result in a negative tower height
            if (minVal < 0) continue;
            
            // Update the difference if the new range is smaller
            diff = Math.min(diff, maxVal - minVal);
        }
        
        return diff;
    }
}
