//{ Driver Code Starts
import java.util.*;

class GFG {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();

        while (tc-- > 0) {
            int s = sc.nextInt();
            int d = sc.nextInt();

            Solution obj = new Solution();
            String res = obj.smallestNumber(s, d);

            System.out.println(res);
        }
    }
}
// } Driver Code Ends



class Solution {
    public String smallestNumber(int s, int d) {
        // If the required sum is greater than the maximum possible sum with d digits, return -1
        if (s > 9 * d) {
            return "-1";
        }

        // Initialize the digits array with zeros
        int[] digits = new int[d];
        
        // Set sum to s initially
        int sum = s;
        
        // Fill the digits array from the last to the first
        for (int i = d - 1; i >= 0; i--) {
            // If the remaining sum is more than 9, put 9 at the current position
            if (sum > 9) {
                digits[i] = 9;
                sum -= 9;
            } else {
                // Otherwise, put the remaining sum at the current position
                digits[i] = sum;
                sum = 0;
            }
        }
        
        // To avoid leading zero issue, if the first digit is 0, we need to make adjustments
        if (digits[0] == 0) {
            for (int i = 1; i < d; i++) {
                if (digits[i] > 0) {
                    digits[i]--;
                    digits[0] = 1;
                    break;
                }
            }
        }
        
        // Convert the digits array to a string
        StringBuilder result = new StringBuilder();
        for (int digit : digits) {
            result.append(digit);
        }
        
        return result.toString();
    }
}

