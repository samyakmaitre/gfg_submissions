//{ Driver Code Starts
// Initial Template for Java

import java.util.*;

class Rat {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int[][] a = new int[n][n];
            for (int i = 0; i < n; i++)
                for (int j = 0; j < n; j++) a[i][j] = sc.nextInt();

            Solution obj = new Solution();
            ArrayList<String> res = obj.findPath(a);
            Collections.sort(res);
            if (res.size() > 0) {
                for (int i = 0; i < res.size(); i++) System.out.print(res.get(i) + " ");
                System.out.println();
            } else {
                System.out.println(-1);
            }
        }
    }
}

// } Driver Code Ends


class Solution {
    public ArrayList<String> findPath(int[][] mat) {
        ArrayList<String> result = new ArrayList<>();
        if (mat[0][0] == 0) {
            return result; // If starting cell is blocked
        }
        int n = mat.length;
        boolean[][] visited = new boolean[n][n];
        findPaths(mat, 0, 0, n, "", visited, result);
        return result;
    }

    private void findPaths(int[][] mat, int i, int j, int n, String path, boolean[][] visited, ArrayList<String> result) {
        // If (i, j) is out of bounds or is blocked or already visited, return
        if (i < 0 || i >= n || j < 0 || j >= n || mat[i][j] == 0 || visited[i][j]) {
            return;
        }

        // If the destination is reached, add the path to the result list
        if (i == n - 1 && j == n - 1) {
            result.add(path);
            return;
        }

        // Mark the cell as visited
        visited[i][j] = true;

        // Explore all possible directions
        findPaths(mat, i + 1, j, n, path + "D", visited, result); // Down
        findPaths(mat, i, j + 1, n, path + "R", visited, result); // Right
        findPaths(mat, i - 1, j, n, path + "U", visited, result); // Up
        findPaths(mat, i, j - 1, n, path + "L", visited, result); // Left

        // Unmark the cell as visited (backtrack)
        visited[i][j] = false;
    }
}