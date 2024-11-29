//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            String a, b;
            a = sc.next();
            b = sc.next();
            Solution ob = new Solution();
            System.out.println(ob.addBinary(a, b));

            System.out.println("~");
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public String addBinary(String s1, String s2) {
        StringBuilder result = new StringBuilder();
        int carry = 0;
        
        int i = s1.length() - 1;
        int j = s2.length() - 1;

        // Add bits from the end of both strings
        while (i >= 0 || j >= 0 || carry > 0) {
            int bit1 = (i >= 0) ? s1.charAt(i) - '0' : 0; // Convert char to int
            int bit2 = (j >= 0) ? s2.charAt(j) - '0' : 0; // Convert char to int
            
            int sum = bit1 + bit2 + carry;
            result.append(sum % 2); // Add current bit to the result
            carry = sum / 2; // Compute carry for the next step
            
            i--;
            j--;
        }

        // Reverse the result as we appended bits in reverse order
        while (result.length() > 1 && result.charAt(result.length() - 1) == '0') {
            result.deleteCharAt(result.length() - 1);
        }
        
        return result.reverse().toString();
    }
}
