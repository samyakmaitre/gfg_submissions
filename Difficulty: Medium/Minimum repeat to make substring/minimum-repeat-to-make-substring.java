//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String A = read.readLine();
            String B = read.readLine();

            Solution ob = new Solution();
            out.println(ob.minRepeats(A, B));
        }
        out.close();
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    static int minRepeats(String s1, String s2) {
        int n = s1.length(), m = s2.length();
        int ans = 1;
        int i = n - 1, j = m - 1;

        // Checking from the back
        while (i >= 0 && j >= 0) {
            if (s1.charAt(i) == s2.charAt(j)) {
                j--;
            } else {
                if (s1.charAt(i) == s2.charAt(m - 1)) {
                    j = m - 2;
                } else {
                    j = m - 1;
                }
            }
            i--;
        }
        
        if (j == -1) return ans;
        if (j == m - 1) return -1;
        
        i = n - 1;
        ans++;
        
        while (j >= 0) {
            if (i == -1) {
                ans++;
                i = n - 1;
            }
            if (s1.charAt(i) != s2.charAt(j)) {
                ans = -1;
                break;
            }
            i--;
            j--;
        }
        
        if (ans != -1) return ans;

        // Checking from the front
        i = 0;
        j = 0;
        ans = 1;
        
        while (i < n && j < m) {
            if (s1.charAt(i) == s2.charAt(j)) {
                j++;
            } else {
                if (s1.charAt(i) == s2.charAt(0)) {
                    j = 1;
                } else {
                    j = 0;
                }
            }
            i++;
        }
        
        if (j == m) return ans;
        if (j == 0) return -1;
        
        i = 0;
        ans++;
        
        while (j < m) {
            if (i == n) {
                ans++;
                i = 0;
            }
            if (s1.charAt(i) != s2.charAt(j)) {
                return -1;
            }
            i++;
            j++;
        }
        
        return ans;
    }
}