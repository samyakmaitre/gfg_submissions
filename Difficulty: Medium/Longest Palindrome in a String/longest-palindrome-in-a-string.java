//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String S = read.readLine();

            Solution ob = new Solution();
            System.out.println(ob.longestPalindrome(S));
            System.out.println("~");
        }
    }
}

// } Driver Code Ends





class Solution {
    static String longestPalindrome(String s) {
        // code here
        int maxlen =1;
        int n = s.length();
        int start =0;
        
        for(int i=0;i<n;i++){
            int len = 1 + length(i-1,i+1,s);
            if(len>maxlen){
                maxlen = len;
                start = i-(len-1)/2;
            }
        }
        
        for(int i=1;i<n;i++){
            int len = length(i-1,i,s);
            if(len>maxlen){
                maxlen = len;
                start = i-len/2;
            }
        }
        return s.substring(start,start+maxlen);
    }
    static int length(int left,int right,String s){
        int len = 0;
        while(left>=0 && right<s.length()){
            if(s.charAt(left) == s.charAt(right)){
                len+=2;
                left--;
                right++;
            }
            else break;
        }
        return len;
    }
}