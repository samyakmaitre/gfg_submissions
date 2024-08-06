//{ Driver Code Starts
// Initial Template for Java

// Initial Template for Java

import java.io.*;
import java.util.*;

public class validip {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            String s = sc.next();
            Solution obj = new Solution();

            if (obj.isValid(s))
                System.out.println("true");
            else
                System.out.println("false");
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public boolean isValid(String str) {
        // Split the string by dots
        String[] parts = str.split("\\.");

        // IPv4 address must contain exactly four parts
        if (parts.length != 4) {
            return false;
        }

        for (String part : parts) {
            // Each part must be a number
            if (!isNumeric(part)) {
                return false;
            }

            // Parse the part to an integer
            int num = Integer.parseInt(part);

            // Each part must be in the range [0, 255]
            if (num < 0 || num > 255) {
                return false;
            }

            // Leading zeroes are not allowed unless the part is exactly "0"
            if (part.length() > 1 && part.startsWith("0")) {
                return false;
            }
        }

        return true;
    }

    // Helper method to check if a string is numeric
    private boolean isNumeric(String str) {
        if (str == null || str.isEmpty()) {
            return false;
        }
        for (char c : str.toCharArray()) {
            if (!Character.isDigit(c)) {
                return false;
            }
        }
        return true;
    }
}
