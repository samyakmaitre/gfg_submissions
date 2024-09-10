//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine().trim());
        while (t-- > 0) {
            String A[] = in.readLine().trim().split(" ");
            int N = Integer.parseInt(A[0]);
            A = in.readLine().trim().split(" ");

            Solution ob = new Solution();
            System.out.println(ob.isCircle(A));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    private void dfs(int node, boolean[] visited, List<List<Integer>> graph) {
        visited[node] = true;
        for (int neighbor : graph.get(node)) {
            if (!visited[neighbor]) {
                dfs(neighbor, visited, graph);
            }
        }
    }

    public int isCircle(String arr[]) {
        int n = arr.length;
        if (n == 0) return 0;

        int[] inDegree = new int[26];
        int[] outDegree = new int[26];

        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            graph.add(new ArrayList<>());
        }

        for (String s : arr) {
            char start = s.charAt(0);
            char end = s.charAt(s.length() - 1);
            outDegree[start - 'a']++;
            inDegree[end - 'a']++;
            graph.get(start - 'a').add(end - 'a');
        }

        for (int i = 0; i < 26; i++) {
            if (inDegree[i] != outDegree[i]) {
                return 0;
            }
        }

        boolean[] visited = new boolean[26];
        int startNode = -1;

        for (int i = 0; i < 26; i++) {
            if (outDegree[i] > 0) {
                startNode = i;
                break;
            }
        }

        if (startNode == -1) {
            return 0;
        }

        dfs(startNode, visited, graph);

        for (int i = 0; i < 26; i++) {
            if (outDegree[i] > 0 && !visited[i]) {
                return 0;
            }
        }

        return 1;
    }
}