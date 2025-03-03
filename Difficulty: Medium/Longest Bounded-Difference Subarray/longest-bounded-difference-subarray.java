//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.util.*;
import java.util.HashMap;


// } Driver Code Ends




class Solution {

    public ArrayList<Integer> longestSubarray(int[] arr, int x) {
        // code here
        int left = 0, maxLength = 0, startIdx = 0;
        Deque<Integer> minDeque = new LinkedList<>();
        Deque<Integer> maxDeque = new LinkedList<>();

        for (int right = 0; right < arr.length; right++) {
            // Maintain minDeque (in increasing order)
            while (!minDeque.isEmpty() && arr[minDeque.getLast()] > arr[right]) {
                minDeque.removeLast();
            }
            minDeque.addLast(right);

            // Maintain maxDeque (in decreasing order)
            while (!maxDeque.isEmpty() && arr[maxDeque.getLast()] < arr[right]) {
                maxDeque.removeLast();
            }
            maxDeque.addLast(right);

            // Shrink window if the condition is violated
            while (arr[maxDeque.getFirst()] - arr[minDeque.getFirst()] > x) {
                left++;
                if (minDeque.getFirst() < left) minDeque.removeFirst();
                if (maxDeque.getFirst() < left) maxDeque.removeFirst();
            }

            // Update the longest subarray details
            if (right - left + 1 > maxLength) {
                maxLength = right - left + 1;
                startIdx = left;
            }
        }

        // Construct the result
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = startIdx; i < startIdx + maxLength; i++) {
            result.add(arr[i]);
        }
        return result;
    }
}

//{ Driver Code Starts.
public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            String line = br.readLine();
            String[] tokens = line.split(" ");

            // Create an ArrayList to store the integers
            ArrayList<Integer> array = new ArrayList<>();

            // Parse the tokens into integers and add to the array
            for (String token : tokens) {
                array.add(Integer.parseInt(token));
            }

            int[] arr = new int[array.size()];
            int idx = 0;
            for (int i : array) arr[idx++] = i;

            int k = Integer.parseInt(br.readLine());
            // Create Solution object and find closest sum
            Solution ob = new Solution();
            ArrayList<Integer> ans = ob.longestSubarray(arr, k);

            // Print the result as a space-separated string
            for (int num : ans) {
                System.out.print(num + " ");
            }
            System.out.println(); // New line after printing the results
            System.out.println("~");
        }
    }
}

// } Driver Code Ends