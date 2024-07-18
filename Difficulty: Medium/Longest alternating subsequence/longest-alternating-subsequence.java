//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.util.*;


// } Driver Code Ends
// User function Template for Java
//Back-end complete function Template for Java
class Solution {
    
    public int alternatingMaxLength(int[] arr) {
        int n = arr.length;
        if (n == 1) return 1;
        if (n == 2) return arr[0] == arr[1] ? 1 : 2;

        int ans = 1;
        int pre = arr[0];
        for (int i = 1; i < n - 1; i++) {
            if ((pre < arr[i] && arr[i] > arr[i + 1]) || (pre > arr[i] && arr[i] < arr[i + 1])) {
                ans++;
                pre = arr[i];
            }
        }
        return ans + 1;
    }
}

//{ Driver Code Starts.

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        while (tc-- > 0) {
            String s[] = br.readLine().trim().split(" ");
            int[] nums = new int[s.length];
            for (int i = 0; i < s.length; i++) {
                nums[i] = Integer.parseInt(s[i]);
            }
            Solution obj = new Solution();
            int ans = obj.alternatingMaxLength(nums);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends