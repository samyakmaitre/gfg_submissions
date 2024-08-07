//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            int k = Integer.parseInt(br.readLine().trim());

            String[] line1 = br.readLine().trim().split(" ");
            int[] arr1 = new int[line1.length];
            for (int i = 0; i < line1.length; i++) {
                arr1[i] = Integer.parseInt(line1[i]);
            }

            String[] line2 = br.readLine().trim().split(" ");
            int[] arr2 = new int[line2.length];
            for (int i = 0; i < line2.length; i++) {
                arr2[i] = Integer.parseInt(line2[i]);
            }

            Solution ob = new Solution();
            System.out.println(ob.kthElement(k, arr1, arr2));
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public long kthElement(int k, int arr1[], int arr2[]) {
        int counter = k;
        int p1 = 0;
        int p2 = 0;
        int result = 0;
        
        while(counter > 0) {
            // If arr1 is exhausted, take from arr2
            if (p1 >= arr1.length) {
                result = arr2[p2];
                p2++;
            } 
            // If arr2 is exhausted, take from arr1
            else if (p2 >= arr2.length) {
                result = arr1[p1];
                p1++;
            } 
            // Otherwise, take the smaller element
            else if (arr1[p1] <= arr2[p2]) {
                result = arr1[p1];
                p1++;
            } 
            else {
                result = arr2[p2];
                p2++;
            }
            
            counter--;
        }
        
        return result;
    }
}
