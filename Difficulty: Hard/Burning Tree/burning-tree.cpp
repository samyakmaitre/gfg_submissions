//{ Driver Code Starts
//Initial Template for C++

#include <bits/stdc++.h>
using namespace std;

struct Node {
    int data;
    Node *left;
    Node *right;

    Node(int val) {
        data = val;
        left = right = NULL;
    }
};


Node *buildTree(string str) {
    // Corner Case
    if (str.length() == 0 || str[0] == 'N')
        return NULL;

    // Creating vector of strings from input
    // string after spliting by space
    vector<string> ip;

    istringstream iss(str);
    for (string str; iss >> str;)
        ip.push_back(str);

    // Create the root of the tree
    Node *root = new Node(stoi(ip[0]));

    // Push the root to the queue
    queue<Node *> queue;
    queue.push(root);

    // Starting from the second element
    int i = 1;
    while (!queue.empty() && i < ip.size()) {

        // Get and remove the front of the queue
        Node *currNode = queue.front();
        queue.pop();

        // Get the current Node's value from the string
        string currVal = ip[i];

        // If the left child is not null
        if (currVal != "N") {

            // Create the left child for the current Node
            currNode->left = new Node(stoi(currVal));

            // Push it to the queue
            queue.push(currNode->left);
        }

        // For the right child
        i++;
        if (i >= ip.size())
            break;
        currVal = ip[i];

        // If the right child is not null
        if (currVal != "N") {

            // Create the right child for the current Node
            currNode->right = new Node(stoi(currVal));

            // Push it to the queue
            queue.push(currNode->right);
        }
        i++;
    }

    return root;
}


// } Driver Code Ends
//User function Template for C++

/*
struct Node {
    int data;
    Node *left;
    Node *right;

    Node(int val) {
        data = val;
        left = right = NULL;
    }
};
*/
class Solution {
  public:
    Node* bfs(Node* root, int target, unordered_map<Node*, Node*>& parent_map) {
        queue<Node*> q;
        Node* start = nullptr;
        q.push(root);

        while (!q.empty()) {
            Node* node = q.front();
            q.pop();

            if (node->data == target) {
                start = node;
            }

            if (node->left) {
                parent_map[node->left] = node;
                q.push(node->left);
            }
            
            if (node->right) {
                parent_map[node->right] = node;
                q.push(node->right);
            }
        }
        return start;
    }

    int gettime(unordered_map<Node*, Node*>& parent_map, Node* start) {
        queue<Node*> q;
        unordered_set<Node*> visited;
        q.push(start);
        visited.insert(start);
        int time = 0;

        while (!q.empty()) {
            int size = q.size();
            bool flag = false;

            for (int i = 0; i < size; i++) {
                Node* node = q.front();
                q.pop();

                if (node->left && visited.find(node->left) == visited.end()) {
                    visited.insert(node->left);
                    q.push(node->left);
                    flag = true;
                }
                
                if (node->right && visited.find(node->right) == visited.end()) {
                    visited.insert(node->right);
                    q.push(node->right);
                    flag = true;
                }

                if (parent_map[node] && visited.find(parent_map[node]) == visited.end()) {
                    visited.insert(parent_map[node]);
                    q.push(parent_map[node]);
                    flag = true;
                }
            }

            if (flag) {
                time++;
            }
        }
        return time;
    }

    int minTime(Node* root, int target) {
        unordered_map<Node*, Node*> parent_map;
        Node* start = bfs(root, target, parent_map);
        return gettime(parent_map, start);
    }
};



//{ Driver Code Starts.

int main() 
{
    int tc;
    scanf("%d ", &tc);
    while (tc--) 
    {    
        string treeString;
        getline(cin, treeString);
        // cout<<treeString<<"\n";
        int target;
        cin>>target;
        // cout<<target<<"\n";

        Node *root = buildTree(treeString);
        Solution obj;
        cout<<obj.minTime(root, target)<<"\n"; 

        cin.ignore();

    }


    return 0;
}

// } Driver Code Ends