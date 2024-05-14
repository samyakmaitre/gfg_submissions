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
    int MinimumEffort(int rows, int columns, vector<vector<int>>& heights) {
        // Define directions for moving up, down, left, right
        vector<pair<int, int>> directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        
        // Priority queue to store the cells to explore (effort, row, col)
        priority_queue<tuple<int, int, int>, vector<tuple<int, int, int>>, greater<tuple<int, int, int>>> pq;
        pq.emplace(0, 0, 0);  // Start with the top-left cell (0, 0) with 0 effort
        
        // 2D list to track the minimum effort to reach each cell
        vector<vector<int>> effort_to(rows, vector<int>(columns, INT_MAX));
        effort_to[0][0] = 0;
        
        while (!pq.empty()) {
            // Get the current cell with the minimum effort
            auto top = pq.top();
            pq.pop();
            int current_effort = get<0>(top);
            int row = get<1>(top);
            int col = get<2>(top);
            
            // If we reached the bottom-right cell, return the effort
            if (row == rows - 1 && col == columns - 1) {
                return current_effort;
            }
            
            // Explore all possible directions
            for (auto direction : directions) {
                int new_row = row + direction.first;
                int new_col = col + direction.second;
                
                // Check if the new position is within bounds
                if (new_row >= 0 && new_row < rows && new_col >= 0 && new_col < columns) {
                    // Calculate the effort to move to the new cell
                    int new_effort = max(current_effort, abs(heights[new_row][new_col] - heights[row][col]));
                    
                    // If this path to the new cell is better, update and push to the priority queue
                    if (new_effort < effort_to[new_row][new_col]) {
                        effort_to[new_row][new_col] = new_effort;
                        pq.emplace(new_effort, new_row, new_col);
                    }
                }
            }
        }
        
        return 0;  // Default return, should never hit here because the goal is always reachable
    }
};


//{ Driver Code Starts.

int main() {
    int t;
    scanf("%d ", &t);
    while (t--) {

        int rows;
        scanf("%d", &rows);

        int columns;
        scanf("%d", &columns);

        vector<vector<int>> heights(rows, vector<int>(columns));
        Matrix::input(heights, rows, columns);

        Solution obj;
        int res = obj.MinimumEffort(rows, columns, heights);

        cout << res << endl;
    }
}

// } Driver Code Ends