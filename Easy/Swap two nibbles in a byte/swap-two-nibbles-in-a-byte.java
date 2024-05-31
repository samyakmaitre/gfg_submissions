//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(read.readLine());
            Solution ob = new Solution();
            System.out.println(ob.swapNibbles(n));
        }
    }
}
// } Driver Code Ends




// User function Template for Java
class Solution {
    static int swapNibbles(int n) {
        // Isolate and shift the higher nibble to the right
        int higherNibble = (n & 0xF0) >> 4;
        // Isolate and shift the lower nibble to the left
        int lowerNibble = (n & 0x0F) << 4;
        // Combine the shifted nibbles
        return higherNibble | lowerNibble;
    }
}
