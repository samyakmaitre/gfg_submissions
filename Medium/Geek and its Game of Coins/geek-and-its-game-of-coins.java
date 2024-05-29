//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            int n;
            n = Integer.parseInt(br.readLine());

            int x;
            x = Integer.parseInt(br.readLine());

            int y;
            y = Integer.parseInt(br.readLine());

            Solution obj = new Solution();
            int res = obj.findWinner(n, x, y);

            System.out.println(res);
        }
    }
}

// } Driver Code Ends



class Solution {
    public static int findWinner(int n, int x, int y) {
       //create a dp array to store the win/loss for each number of coins
       boolean[] dp = new boolean[n+1];
       //Base case: if there are 0 coins, the player to play loses
       dp[0]=false;
       //fill the dp array using the rules of the game
       for (int i = 1; i<=n;i++){
           //check the three possible moves and set dp[i] accordingly
           dp[i]=!dp[i-1];
           if (i>=x){
               dp[i]=dp[i] || !dp[i-x];
           }
           if(i>=y){
               dp[i] = dp[i] || !dp[i-y];
           }
       }
       //return 1 if geek wins with n coins
       return dp[n] ? 1:0;
    }
}
