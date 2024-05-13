//{ Driver Code Starts
#include <bits/stdc++.h>
using namespace std;

class Matrix {
  public:
    template <class T>
    static void input(vector<vector<T>> &A, int n, int m) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                scanf("%d ", &A[i][j]);
            }
        }
    }

    template <class T>
    static void print(vector<vector<T>> &A) {
        for (int i = 0; i < A.size(); i++) {
            for (int j = 0; j < A[i].size(); j++) {
                cout << A[i][j] << " ";
            }
            cout << endl;
        }
    }
};


// } Driver Code Ends

class Solution {
public:
    void dfs(int node, vector<int> adj[], int size, int &cv, bool &flag, vector<int> &vis) {
        vis[node] = 1;
        cv++;
        if(size != adj[node].size())
            flag = false;
        for(auto v: adj[node])
            if(!vis[v])
                dfs(v, adj, size, cv, flag, vis);
    }
    int findNumberOfGoodComponent(int e, int v, vector<vector<int>> &edges) {
        vector<int> vis(v + 1), adj[v + 1];
        for(auto i: edges) {
            adj[i[0]].push_back(i[1]);
            adj[i[1]].push_back(i[0]);
        }
        int count = 0;
        for(int i = 1; i <= v; i++) {
            if(!vis[i]) {
                bool flag = true;
                int cv = 0;
                dfs(i, adj, adj[i].size(), cv, flag, vis);
                if(flag and cv == 1 + adj[i].size())
                    count++;
            }
        }
        return count;
    }
};


//{ Driver Code Starts.

int main() {
    int t;
    scanf("%d ", &t);
    while (t--) {

        int e;
        scanf("%d", &e);

        int v;
        scanf("%d", &v);

        vector<vector<int>> edges(e, vector<int>(2));
        Matrix::input(edges, e, 2);

        Solution obj;
        int res = obj.findNumberOfGoodComponent(e, v, edges);

        cout << res << endl;
    }
}

// } Driver Code Ends