//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;


// } Driver Code Ends
// User function Template for Java

// User function Template for Java

class Solution {

    int countPairs(int arr[], int target) {
        int i = 0, j = arr.length - 1, ans = 0;
        Arrays.sort(arr);

        while (i < j) {
            int sum = arr[i] + arr[j];
            if (sum == target) {
                if (arr[i] == arr[j]) {
                    int temp = j - i + 1;
                    ans += (temp * (temp - 1)) / 2;
                    break;
                } else {
                    int left = 1, right = 1;
                    while (i + 1 < j && arr[i] == arr[i + 1]) {
                        left++;
                        i++;
                    }
                    while (i < j - 1 && arr[j] == arr[j - 1]) {
                        right++;
                        j--;
                    }
                    ans += left * right;
                    i++;
                    j--;
                }
            } else if (sum < target) {
                i++;
            } else {
                j--;
            }
        }
        return ans;
    }
}


//{ Driver Code Starts.
class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim()); // Inputting the testcases
        while (t-- > 0) {
            String[] inputLine = br.readLine().trim().split(" ");
            int[] arr = new int[inputLine.length];
            for (int i = 0; i < inputLine.length; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }
            inputLine = br.readLine().trim().split(" ");
            int target = Integer.parseInt(inputLine[0]);

            Solution obj = new Solution();
            int res = obj.countPairs(arr, target);
            System.out.println(res);
            System.out.println("~");
        }
    }
}
// } Driver Code Ends