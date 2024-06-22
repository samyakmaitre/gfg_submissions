//{ Driver Code Starts
// Initial Template for C++

#include <bits/stdc++.h>
using namespace std;


// } Driver Code Ends
// User function Template for C++

class Solution {
  public:
    long long ExtractNumber(string s) {

        // code here
        long long ans=-1;
        long long curr=0;
        int i=0, n=s.length();
        while(i<n){
            curr=0;
            bool flag=true;
            while(i<n && s[i]!=' '){
                if(flag && s[i]>='0' && s[i]<='8'){
                    curr=curr*10+(s[i]-'0');
                }
                else{
                    flag=false;
                }
                i++;
            }
            i++;
            if(flag){
                ans=max(ans, curr);
            }
        }
        return ans;
    }
};

//{ Driver Code Starts.
int main() {

    ios_base::sync_with_stdio(0);
    cin.tie(NULL);
    cout.tie(NULL);

    int t;
    string tc;
    getline(cin, tc);
    t = stoi(tc);
    while (t--) {
        string s;
        getline(cin, s);

        Solution ob;
        cout << ob.ExtractNumber(s) << "\n";
    }

    return 0;
}

// } Driver Code Ends