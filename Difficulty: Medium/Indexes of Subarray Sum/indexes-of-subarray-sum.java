//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine().trim());

        while (t-- > 0) {
            String line = read.readLine().trim();
            String[] numsStr = line.split(" ");
            int[] nums = new int[numsStr.length];
            for (int i = 0; i < numsStr.length; i++) {
                nums[i] = Integer.parseInt(numsStr[i]);
            }

            int d = Integer.parseInt(read.readLine().trim());

            Solution ob = new Solution();
            ArrayList<Integer> result = ob.subarraySum(nums, d);
            // Print all elements in the result list
            for (int i : result) {
                System.out.print(i + " ");
            }
            System.out.println(); // Print a new line after the result
            System.out.println("~");
        }
    }
}

// } Driver Code Ends






class Solution {
    static ArrayList<Integer> subarraySum(int[] arr, int target) {
        int i = 0; // Initialize the starting pointer of the sliding window
    int sum = 0; // Initialize the sum of the current window

    // Iterate through the array with the ending pointer of the sliding window
    for (int j = 0; j < arr.length; j++) {
        sum += arr[j]; // Add the current element to the sum

        // While the current sum is greater than the target and the window is valid
        while (sum > target && i <= j) {
            sum -= arr[i]; // Remove the element at the start of the window
            i++; // Shrink the window from the left
        }

        // If the sum of the current window equals the target
        if (sum == target) {
            // Return the 1-based indexes of the start and end of the subarray
            ArrayList<Integer> result = new ArrayList<>();
            result.add(i + 1);
            result.add(j + 1);
            return result;
        }
    }

    // If no subarray with the given sum is found, return -1
    ArrayList<Integer> result = new ArrayList<>();
    result.add(-1);
    return result;
        
    }
}