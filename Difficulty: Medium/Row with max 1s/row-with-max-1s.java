//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            inputLine = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine[0]);
            int m = Integer.parseInt(inputLine[1]);
            int[][] arr = new int[n][m];
            inputLine = br.readLine().trim().split(" ");

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    arr[i][j] = Integer.parseInt(inputLine[i * m + j]);
                }
            }
            int ans = new Solution().rowWithMax1s(arr);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends

 
// User function Template for Java

class Solution {
    public int rowWithMax1s(int arr[][]) {
        int rows = arr.length;
        int cols = arr[0].length;
        
        int mostSum = 0;
        int currSum = 0;
        int rowIdx = 0;
        
        for(int i = 0 ; i<rows; i++)
        {
            for(int j=0; j<cols; j++)
            {
                currSum += arr[i][j];
            }
            if(currSum == cols)
            {
                return i;
            }
            if(currSum > mostSum){
                mostSum = currSum;
                rowIdx = i;
            }
            currSum=0;
        }
        if(mostSum==0){
            return -1;
        }else{
            return rowIdx;
        }
        
    }
}