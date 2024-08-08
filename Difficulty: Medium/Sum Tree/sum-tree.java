//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;
import java.util.LinkedList;
import java.util.Queue;

class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

class GfG {

    static Node buildTree(String str) {

        if (str.length() == 0 || str.charAt(0) == 'N') {
            return null;
        }

        String ip[] = str.split(" ");
        // Create the root of the tree
        Node root = new Node(Integer.parseInt(ip[0]));
        // Push the root to the queue

        Queue<Node> queue = new LinkedList<>();

        queue.add(root);
        // Starting from the second element

        int i = 1;
        while (queue.size() > 0 && i < ip.length) {

            // Get and remove the front of the queue
            Node currNode = queue.peek();
            queue.remove();

            // Get the current node's value from the string
            String currVal = ip[i];

            // If the left child is not null
            if (!currVal.equals("N")) {

                // Create the left child for the current node
                currNode.left = new Node(Integer.parseInt(currVal));
                // Push it to the queue
                queue.add(currNode.left);
            }

            // For the right child
            i++;
            if (i >= ip.length) break;

            currVal = ip[i];

            // If the right child is not null
            if (!currVal.equals("N")) {

                // Create the right child for the current node
                currNode.right = new Node(Integer.parseInt(currVal));

                // Push it to the queue
                queue.add(currNode.right);
            }
            i++;
        }

        return root;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        while (t > 0) {
            String s = br.readLine();
            Node root = buildTree(s);
            Solution g = new Solution();
            System.out.println(g.isSumTree(root));
            // if (g.isSumTree(root) == true)
            //     System.out.println(1);
            // else
            //     System.out.println(0);
            t--;
        }
    }
}

// } Driver Code Ends


/* A Binary Tree node
class Node
{
    int data;
    Node left, right;

    Node(int item)
    {
        data = item;
        left = right = null;
    }
}
*/
class Solution {

    // Helper function to check if the tree is a Sum Tree and return the sum of the tree.
    private int sumTreeUtil(Node node) {
        // If the node is null, return 0 (sum of an empty tree)
        if (node == null) return 0;
        
        // If the node is a leaf, return its value
        if (node.left == null && node.right == null) return node.data;
        
        // Recursively get the sum of the left and right subtrees
        int leftSum = sumTreeUtil(node.left);
        int rightSum = sumTreeUtil(node.right);
        
        // If either left or right subtree is not a Sum Tree, return Integer.MIN_VALUE
        if (leftSum == Integer.MIN_VALUE || rightSum == Integer.MIN_VALUE) return Integer.MIN_VALUE;
        
        // If the current node's data is equal to the sum of left and right subtrees
        if (node.data == leftSum + rightSum) {
            // Return the sum of the tree rooted at this node
            return node.data + leftSum + rightSum;
        } else {
            // If the current node is not satisfying the Sum Tree property, return Integer.MIN_VALUE
            return Integer.MIN_VALUE;
        }
    }
    
    // Function to check if the tree is a Sum Tree
    boolean isSumTree(Node root) {
        // Call the helper function and check if the result is not Integer.MIN_VALUE
        return sumTreeUtil(root) != Integer.MIN_VALUE;
    }
}

