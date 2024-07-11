//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int[][] grid = new int[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    grid[i][j] = sc.nextInt();
                }
            }

            Solution obj = new Solution();
            int ans = obj.MaxConnection(grid);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


class Solution {
    private int n;
    private int[][] grid;
    private int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    
    public int MaxConnection(int[][] grid) {
        this.n = grid.length;
        this.grid = grid;
        int maxGroupSize = 0;
        
        int[][] component = new int[n][n];
        Map<Integer, Integer> componentSize = new HashMap<>();
        int componentId = 2; // Start from 2 to distinguish from 1 and 0 in grid
        
        // Step 1: Find all components and their sizes
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1 && component[i][j] == 0) {
                    int size = dfs(i, j, componentId, component);
                    componentSize.put(componentId, size);
                    componentId++;
                }
            }
        }
        
        // Step 2: Check each 0 and calculate potential max connected 1's
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    Set<Integer> seenComponents = new HashSet<>();
                    int potentialSize = 1; // changing the current 0 to 1
                    
                    for (int[] dir : directions) {
                        int ni = i + dir[0];
                        int nj = j + dir[1];
                        
                        if (ni >= 0 && ni < n && nj >= 0 && nj < n && grid[ni][nj] == 1) {
                            int compId = component[ni][nj];
                            if (!seenComponents.contains(compId)) {
                                seenComponents.add(compId);
                                potentialSize += componentSize.get(compId);
                            }
                        }
                    }
                    
                    maxGroupSize = Math.max(maxGroupSize, potentialSize);
                }
            }
        }
        
        // Step 3: Return the result
        // If no 0's were changed, find the max size of existing components
        if (maxGroupSize == 0) {
            for (int size : componentSize.values()) {
                maxGroupSize = Math.max(maxGroupSize, size);
            }
        }
        
        return maxGroupSize;
    }
    
    private int dfs(int i, int j, int componentId, int[][] component) {
        Stack<int[]> stack = new Stack<>();
        stack.push(new int[]{i, j});
        component[i][j] = componentId;
        int size = 0;
        
        while (!stack.isEmpty()) {
            int[] cell = stack.pop();
            int x = cell[0], y = cell[1];
            size++;
            
            for (int[] dir : directions) {
                int nx = x + dir[0];
                int ny = y + dir[1];
                
                if (nx >= 0 && nx < n && ny >= 0 && ny < n && grid[nx][ny] == 1 && component[nx][ny] == 0) {
                    stack.push(new int[]{nx, ny});
                    component[nx][ny] = componentId;
                }
            }
        }
        
        return size;
    }
}
