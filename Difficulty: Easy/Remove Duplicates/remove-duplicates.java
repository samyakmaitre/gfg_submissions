//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String s = read.readLine();

            Solution ob = new Solution();
            String result = ob.removeDups(s);

            System.out.println(result);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    String removeDups(String str) {
        // Create a HashSet to keep track of seen characters
        HashSet<Character> seen = new HashSet<>();
        // Create a StringBuilder to build the result string
        StringBuilder result = new StringBuilder();
        
        // Iterate through each character in the string
        for (char ch : str.toCharArray()) {
            // If the character has not been seen before
            if (!seen.contains(ch)) {
                // Add it to the result and mark it as seen
                result.append(ch);
                seen.add(ch);
            }
        }
        
        // Convert the StringBuilder to a string and return it
        return result.toString();
    }
}