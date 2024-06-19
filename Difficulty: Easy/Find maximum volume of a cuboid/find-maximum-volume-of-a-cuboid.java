//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());

        while (t-- > 0) {
            String arr[] = read.readLine().trim().split("\\s+");
            double perimeter = Double.parseDouble(arr[0]);
            double area = Double.parseDouble(arr[1]);

            Solution ob = new Solution();
            double ans = ob.maxVolume(perimeter, area);
            System.out.println(String.format("%.2f", ans));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {

    double maxVolume(double P, double A) {
        // code here
         // calculate length
        double l
            = (double)(P - Math.sqrt(P * P - 24 * A)) / 12;
 
    double height = (P / 4) - (2 * (l));
        
         double ans = l * l* height;
          return ans;
    }
}