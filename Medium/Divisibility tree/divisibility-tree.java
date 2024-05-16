//{ Driver Code Starts
import java.io.*;
import java.util.*;

class IntMatrix {
    public static int[][] input(BufferedReader br, int n, int m) throws IOException {
        int[][] mat = new int[n][];

        for (int i = 0; i < n; i++) {
            String[] s = br.readLine().trim().split(" ");
            mat[i] = new int[s.length];
            for (int j = 0; j < s.length; j++) mat[i][j] = Integer.parseInt(s[j]);
        }

        return mat;
    }

    public static void print(int[][] m) {
        for (var a : m) {
            for (int e : a) System.out.print(e + " ");
            System.out.println();
        }
    }

    public static void print(ArrayList<ArrayList<Integer>> m) {
        for (var a : m) {
            for (int e : a) System.out.print(e + " ");
            System.out.println();
        }
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            int n;
            n = Integer.parseInt(br.readLine());

            int[][] edges = IntMatrix.input(br, n - 1, 2);

            Solution obj = new Solution();
            int res = obj.minimumEdgeRemove(n, edges);

            System.out.println(res);
        }
    }
}

// } Driver Code Ends



class Solution {
    public int minimumEdgeRemove(int n, int[][] edges) {
        // Create adjacency list
        List<List<Integer>> tree = new ArrayList<>();
        for (int i = 0; i < n + 1; i++) {
            tree.add(new ArrayList<>());
        }
        
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            tree.get(u).add(v);
            tree.get(v).add(u);
        }
        
        // Array to store size of each subtree
        int[] subtreeSize = new int[n + 1];
        boolean[] visited = new boolean[n + 1];
        
        // Start DFS from the root node 1
        dfs(1, tree, visited, subtreeSize);
        
        int removableEdges = 0;
        
        // Traverse the subtree sizes to find removable edges
        for (int i = 2; i <= n; i++) {
            if (subtreeSize[i] % 2 == 0) {
                removableEdges++;
            }
        }
        
        return removableEdges;
    }
    
    private int dfs(int node, List<List<Integer>> tree, boolean[] visited, int[] subtreeSize) {
        visited[node] = true;
        int size = 1; // Include current node
        
        for (int neighbor : tree.get(node)) {
            if (!visited[neighbor]) {
                size += dfs(neighbor, tree, visited, subtreeSize);
            }
        }
        
        subtreeSize[node] = size;
        return size;
    }
}
