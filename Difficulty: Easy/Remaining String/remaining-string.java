//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            String s = sc.next();
            char ch = sc.next().charAt(0);
            int count = sc.nextInt();
            Solution ob = new Solution();
            String result = ob.printString(s, ch, count);

            System.out.println(result);
        }
    }
}
// } Driver Code Ends


class Solution {
    public String printString(String s, char ch, int count) {
        int pos = -1;
        for(int j=0 ; j<s.length(); j++){
            if(s.charAt(j)==ch && count>0){
                pos=j;
                count--;
            }
            
        }
        if(pos==-1 || count>0){
            return "";
        }
       
        String sb = "";
        for(int j=pos+1; j<s.length(); j++){
            sb += s.charAt(j);
        }
        
        return sb;
        
    }
}