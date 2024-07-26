//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine().trim());
        while (t-- > 0) {
            String str = sc.nextLine();
            int k = Integer.parseInt(sc.nextLine().trim());
            Solution obj = new Solution();
            if (obj.kPangram(str, k))
                System.out.println("true");
            else
                System.out.println("false");
        }
    }
}
// } Driver Code Ends


// User function Template for Java
public class Solution {

    public boolean kPangram(String str, int k) {
        int[] arr = new int[26];
        int count = 0;
        int op = 0;

        // Count the occurrences of each letter in the string
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c != ' ') {
                int index = c - 'a';
                if (index >= 0 && index < 26) {
                    arr[index]++;
                    count++;
                }
            }
        }

        // Count the number of missing letters
        for (int i = 0; i < 26; i++) {
            if (arr[i] == 0) {
                op++;
            }
        }

        // Return true if the number of missing letters is less than or equal to k and the total count is at least 26
        return (op <= k) && (count >= 26);
    }
}
