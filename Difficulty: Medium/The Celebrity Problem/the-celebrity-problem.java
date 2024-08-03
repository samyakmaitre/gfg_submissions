//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0) {
            int N = sc.nextInt();
            int M[][] = new int[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    M[i][j] = sc.nextInt();
                }
            }
            System.out.println(new Solution().celebrity(M));
            t--;
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public int celebrity(int mat[][]) {
        int numPeople = mat.length;
        int candidate = 0;
        
        for (int i = 1; i < numPeople; i++) {
            if (mat[candidate][i] == 1) {
                candidate = i;
            }
        }
        
        for (int i = 0; i < numPeople; i++) {
            if (i != candidate && (mat[candidate][i] == 1 || mat[i][candidate] == 0)) {
                return -1;
            }
        }
        
        return candidate;
    }
}

