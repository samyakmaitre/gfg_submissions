//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            int n;
            n = Integer.parseInt(br.readLine());

            Solution obj = new Solution();
            int res = obj.countNumberswith4(n);

            System.out.println(res);
        }
    }
}

// } Driver Code Ends



class Solution {
    public static int countNumberswith4(int n) {
        int count = 0;
        
        for (int i = 1; i <= n; i++) {
            // Convert the number to a string
            String numStr = Integer.toString(i);
            
            // Check if '4' is present in the string
            if (numStr.contains("4")) {
                count++;
            }
        }
        
        return count;
    }
}
