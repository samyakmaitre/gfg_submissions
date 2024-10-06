//{ Driver Code Starts
import java.util.*;

class GFG {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int tc = scanner.nextInt(); // Number of test cases
        while (tc-- > 0) {
            int n = scanner.nextInt(); // Number of rows
            int m = scanner.nextInt(); // Number of columns
            char[][] grid = new char[n][m];

            // Read the grid input
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    grid[i][j] = scanner.next().charAt(0);
                }
            }
            Solution obj = new Solution();
            int ans = obj.numIslands(grid);
            System.out.println(ans);
        }
        scanner.close();
    }
}

// } Driver Code Ends


class Solution {
    // Directions array for moving in all 8 possible directions
    private final int[][] directions = {
        {-1, -1}, {-1, 0}, {-1, 1},
        {0, -1},         {0, 1},
        {1, -1}, {1, 0}, {1, 1}
    };

    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) return 0;

        int rows = grid.length;
        int cols = grid[0].length;
        int islandCount = 0;

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                // If we find land, it's a new island
                if (grid[r][c] == '1') {
                    islandCount++;
                    // Perform iterative DFS to mark all parts of this island
                    iterativeDFS(grid, r, c);
                }
            }
        }

        return islandCount;
    }

    private void iterativeDFS(char[][] grid, int startRow, int startCol) {
        Stack<int[]> stack = new Stack<>();
        stack.push(new int[]{startRow, startCol});

        while (!stack.isEmpty()) {
            int[] position = stack.pop();
            int r = position[0];
            int c = position[1];

            // Check if the current position is out of bounds or is water
            if (r < 0 || r >= grid.length || c < 0 || c >= grid[0].length || grid[r][c] == '0') {
                continue;
            }

            // Mark the cell as visited (water)
            grid[r][c] = '0';

            // Visit all 8 adjacent cells
            for (int[] direction : directions) {
                stack.push(new int[]{r + direction[0], c + direction[1]});
            }
        }
    }
}