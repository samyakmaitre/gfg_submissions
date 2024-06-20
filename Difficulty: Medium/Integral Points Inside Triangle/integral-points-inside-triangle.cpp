//{ Driver Code Starts
// Initial Template for C++

#include <bits/stdc++.h>
using namespace std;

// } Driver Code Ends
// User function Template for C++

class Solution {
public:
    long long gcd(long long a, long long b) {
        while (b != 0) {
            long long temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
    
    long long InternalCount(long long p[], long long q[], long long r[]) {
        // Step 1: Calculate the area using the determinant method (shoelace formula)
        long long area = std::abs(p[0]*(q[1] - r[1]) + q[0]*(r[1] - p[1]) + r[0]*(p[1] - q[1]));
        
        // Step 2: Count the boundary points using GCD
        long long bp1 = gcd(std::abs(p[0] - q[0]), std::abs(p[1] - q[1])) + 1;
        long long bp2 = gcd(std::abs(q[0] - r[0]), std::abs(q[1] - r[1])) + 1;
        long long bp3 = gcd(std::abs(r[0] - p[0]), std::abs(r[1] - p[1])) + 1;
        
        // Total boundary points (subtracting the 3 vertices counted in each edge)
        long long B = bp1 + bp2 + bp3 - 3;
        
        // Step 3: Apply Pick's Theorem
        long long I = (area - B) / 2 + 1;
        
        return I;
    }
};

//{ Driver Code Starts.
int main() {
    int t;
    cin >> t;
    while (t--) {
        long long int p[2], q[2], r[2];
        cin >> p[0] >> p[1] >> q[0] >> q[1] >> r[0] >> r[1];
        Solution ob;
        long long int ans = ob.InternalCount(p, q, r);
        cout << ans << "\n";
    }
}
// } Driver Code Ends