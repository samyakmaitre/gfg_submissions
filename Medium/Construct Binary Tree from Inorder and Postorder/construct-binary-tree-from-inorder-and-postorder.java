//{ Driver Code Starts
import java.util.*;

class Node {
    int data;
    Node left;
    Node right;

    Node(int value) {
        data = value;
        left = null;
        right = null;
    }
}

class InorderPostorderToTree {
    public void preOrder(Node root) {
        if (root == null) return;

        System.out.print(root.data + " ");
        preOrder(root.left);

        preOrder(root.right);
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        InorderPostorderToTree ip = new InorderPostorderToTree();
        int T = sc.nextInt();
        while (T > 0) {
            int n = sc.nextInt();
            int inorder[] = new int[n];
            int postorder[] = new int[n];
            for (int i = 0; i < n; i++) inorder[i] = sc.nextInt();
            for (int i = 0; i < n; i++) postorder[i] = sc.nextInt();
            GfG g = new GfG();
            Node root = g.buildTree(inorder, postorder, n);
            ip.preOrder(root);
            System.out.println();

            T--;
        }
    }
}

// } Driver Code Ends


/* Tree node structure
class Node
{
    int data;
    Node left;
    Node right;

        Node(int value)
    {
        data = value;
        left = null;
        right = null;
    }
}*/


class GfG {
    // Function to return a tree created from postorder and inorder traversals.
    Node buildTree(int in[], int post[], int n) {
        // Map to store the indices of elements in inorder traversal
        Map<Integer, Integer> indexMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            indexMap.put(in[i], i);
        }
        
        // Construct the tree recursively
        return buildTreeUtil(in, post, 0, n - 1, 0, n - 1, indexMap);
    }
    
    // Utility function to construct the tree recursively
    Node buildTreeUtil(int[] in, int[] post, int inStart, int inEnd, int postStart, int postEnd, Map<Integer, Integer> indexMap) {
        // Base case
        if (inStart > inEnd || postStart > postEnd) {
            return null;
        }
        
        // The last element in postorder traversal is the root
        int rootVal = post[postEnd];
        Node root = new Node(rootVal);
        
        // Find the index of root in inorder traversal
        int rootIndex = indexMap.get(rootVal);
        
        // Recursively construct left and right subtrees
        // based on inorder traversal
        root.left = buildTreeUtil(in, post, inStart, rootIndex - 1, postStart, postStart + rootIndex - inStart - 1, indexMap);
        root.right = buildTreeUtil(in, post, rootIndex + 1, inEnd, postStart + rootIndex - inStart, postEnd - 1, indexMap);
        
        return root;
    }
}

