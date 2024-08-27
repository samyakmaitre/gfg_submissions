//{ Driver Code Starts
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            String input = br.readLine();
            String[] inputs = input.split(" ");
            int[] arr = new int[inputs.length];

            for (int i = 0; i < inputs.length; i++) {
                arr[i] = Integer.parseInt(inputs[i]);
            }

            Solution ob = new Solution();
            System.out.println(ob.findMaxDiff(arr));
        }
    }
}

// } Driver Code Ends

class Solution {
    public int findMaxDiff(int[] arr) {
        int n = arr.length;
        int[] ls = new int[n]; // left smaller array
        int[] rs = new int[n]; // right smaller array
        
        Stack<Integer> stack = new Stack<>();
        
        // Fill the left smaller array
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && stack.peek() >= arr[i]) {
                stack.pop();
            }
            ls[i] = stack.isEmpty() ? 0 : stack.peek();
            stack.push(arr[i]);
        }
        
        // Clear the stack to reuse for right smaller array
        stack.clear();
        
        // Fill the right smaller array
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() >= arr[i]) {
                stack.pop();
            }
            rs[i] = stack.isEmpty() ? 0 : stack.peek();
            stack.push(arr[i]);
        }
        
        // Calculate the maximum absolute difference
        int maxDiff = 0;
        for (int i = 0; i < n; i++) {
            maxDiff = Math.max(maxDiff, Math.abs(ls[i] - rs[i]));
        }
        
        return maxDiff;
    }
}
