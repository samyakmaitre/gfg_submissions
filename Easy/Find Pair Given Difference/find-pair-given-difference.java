//{ Driver Code Starts
import java.io.*;
import java.util.*;

class IntArray {
    public static int[] input(BufferedReader br, int n) throws IOException {
        String[] s = br.readLine().trim().split(" ");
        int[] a = new int[n];
        for (int i = 0; i < n; i++) a[i] = Integer.parseInt(s[i]);

        return a;
    }

    public static void print(int[] a) {
        for (int e : a) System.out.print(e + " ");
        System.out.println();
    }

    public static void print(ArrayList<Integer> a) {
        for (int e : a) System.out.print(e + " ");
        System.out.println();
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

            int x;
            x = Integer.parseInt(br.readLine());

            int[] arr = IntArray.input(br, n);

            Solution obj = new Solution();
            int res = obj.findPair(n, x, arr);

            System.out.println(res);
        }
    }
}

// } Driver Code Ends



class Solution {
    public int findPair(int n, int x, int[] arr) {
        // Create a HashSet to store the elements of the array
        HashSet<Integer> set = new HashSet<>();

        // Iterate through each element in the array
        for (int i = 0; i < n; i++) {
            // Check if there exists an element in the set such that the absolute difference with arr[i] is x
            if (set.contains(arr[i] + x) || set.contains(arr[i] - x)) {
                // If found, return 1
                return 1;
            }
            // Add the current element to the set
            set.add(arr[i]);
        }

        // If no such pair is found, return -1
        return -1;
    }
}