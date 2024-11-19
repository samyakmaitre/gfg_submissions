//{ Driver Code Starts
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;


// } Driver Code Ends
// User function Template for Java

class Solution {
    void nextPermutation(int[] arr) {
        int n=arr.length, pt1=n;
        for(int i=n-2;i>=0;i--){
            if(arr[i]<arr[i+1]){
                pt1=i;
                break;
            }
        }
        
        //decending array
        if(pt1==n){
            Arrays.sort(arr);
            return;
        }
        
        //find point to swap
        int pt2=n;
        for(int i=n-1;i>=0;i--){
            if(arr[i]>arr[pt1]){
                pt2=i;
                break;
            }
        }
        
        // swap(arr,pt1,pt2);
        int temp = arr[pt1];
        arr[pt1] = arr[pt2];
        arr[pt2] = temp;
        
        Arrays.sort(arr,pt1+1,n);
    }
}


//{ Driver Code Starts.

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine()); // Number of test cases
        while (tc-- > 0) {
            String[] inputLine = br.readLine().split(" ");
            int[] arr = new int[inputLine.length];
            for (int i = 0; i < inputLine.length; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }
            int N = arr.length;
            Solution ob = new Solution();
            ob.nextPermutation(arr); // Generate the next permutation
            StringBuilder out = new StringBuilder();
            for (int i = 0; i < N; i++) {
                out.append(arr[i] + " "); // Corrected: use arr[i] instead of arr.get(i)
            }
            System.out.println(out.toString().trim()); // Print the output

            System.out.println("~");
        }
    }
}
// } Driver Code Ends