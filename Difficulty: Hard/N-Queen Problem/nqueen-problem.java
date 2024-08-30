//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(in.readLine());

            Solution ob = new Solution();
            ArrayList<ArrayList<Integer>> ans = ob.nQueen(n);
            if (ans.size() == 0)
                System.out.println("-1");
            else {
                for (int i = 0; i < ans.size(); i++) {
                    System.out.print("[");
                    for (int j = 0; j < ans.get(i).size(); j++)
                        System.out.print(ans.get(i).get(j) + " ");
                    System.out.print("] ");
                }
                System.out.println();
            }
        }
    }
}
// } Driver Code Ends

// User function Template for Java
class Solution {
    public ArrayList<ArrayList<Integer>> nQueen(int n) {
        ArrayList<ArrayList<Integer>> solutions = new ArrayList<>();
        ArrayList<Integer> board = new ArrayList<>();
        solvedNQueens(n,0,board,solutions);
        return solutions;
    }
    
    private void solvedNQueens(int n, int col, ArrayList<Integer> board, ArrayList<ArrayList<Integer>> solutions){
        
        //base case
        if(col == n){
            solutions.add(new ArrayList<>(board));
            return;
        }
        
        for(int row=1; row<=n; row++){
            if(isValid(board, row, col)){
                board.add(row);
                solvedNQueens(n, col+1, board, solutions);
                board.remove(board.size()-1); //backtrack
            }
        }
    }
    
    private boolean isValid(ArrayList<Integer> board, int row, int col){
        for(int i=0; i<col; i++){
            int placedRow = board.get(i);
            if(placedRow == row || Math.abs(placedRow - row) == Math.abs(i-col)){
                return false;
            }
        }
        return true;
    }
}