//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
class GfG
{
    public static void main(String args[])
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    int n = sc.nextInt();
                    Solution ob = new Solution();
                    System.out.println(ob.padovanSequence(n));
                }
        }
}    
// } Driver Code Ends


//User function Template for Java

class Solution
{
    int m = 1000000007;
  public int padovanSequence(int n)
    {
        //code here.
        if(n<=2)
        return 1;
        int a=1,b=1,c=1,d=0;


        for(int i=3; i<=n ;i++){
            d=(a%m + b%m)%m;
            a=b; b=c; c=d;
        } 
        return d;
    }

}
