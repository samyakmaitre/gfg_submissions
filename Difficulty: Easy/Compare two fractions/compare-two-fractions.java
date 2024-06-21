//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class GFG {
    public static void main(String args[]) throws IOException {

        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

        Solution ob = new Solution();
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String str = read.readLine().trim();
            String ans = ob.compareFrac(str);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {

    String compareFrac(String str) 
    {
        String[] fractions = str.split(", ");
        
        // Parse the fractions into numerators and denominators
        String[] fraction1 = fractions[0].split("/");
        String[] fraction2 = fractions[1].split("/");
        
        int numerator1 = Integer.parseInt(fraction1[0]);
        int denominator1 = Integer.parseInt(fraction1[1]);
        
        int numerator2 = Integer.parseInt(fraction2[0]);
        int denominator2 = Integer.parseInt(fraction2[1]);
        
        // Compare fractions by cross-multiplying to avoid division
        if (numerator1 * denominator2 > numerator2 * denominator1) {
            return fractions[0];
        }
        else if (numerator1 * denominator2 < numerator2 * denominator1) {
            return fractions[1];
        }
        else {
            return "equal";
        }
    }
}
