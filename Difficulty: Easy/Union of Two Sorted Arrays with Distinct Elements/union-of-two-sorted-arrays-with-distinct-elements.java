//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            // First array input
            String[] str1 = br.readLine().trim().split(
                " "); // Read the first line and split by spaces
            int n = str1.length;
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(str1[i]); // Convert each element to an integer
            }

            // Second array input
            String[] str2 = br.readLine().trim().split(
                " "); // Read the second line and split by spaces
            int m = str2.length;
            int[] b = new int[m];
            for (int i = 0; i < m; i++) {
                b[i] = Integer.parseInt(str2[i]); // Convert each element to an integer
            }

            Solution obj = new Solution();
            ArrayList<Integer> res = new ArrayList<Integer>();
            res = obj.findUnion(a, b);
            for (int i = 0; i < res.size(); i++) System.out.print(res.get(i) + " ");
            System.out.println();

            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    // Function to return a list containing the union of the two arrays.
    public static ArrayList<Integer> findUnion(int a[], int b[]) {
        ArrayList<Integer> unionList = new ArrayList<>();
        int i = 0, j = 0;

        // Traverse both arrays using two pointers.
        while (i < a.length && j < b.length) {
            // Skip duplicate elements in the result list
            if (!unionList.isEmpty() && unionList.get(unionList.size() - 1) == a[i]) {
                i++;
                continue;
            }
            if (!unionList.isEmpty() && unionList.get(unionList.size() - 1) == b[j]) {
                j++;
                continue;
            }

            // If the element in a is smaller, add it to the unionList and move pointer i.
            if (a[i] < b[j]) {
                unionList.add(a[i]);
                i++;
            }
            // If the element in b is smaller, add it to the unionList and move pointer j.
            else if (a[i] > b[j]) {
                unionList.add(b[j]);
                j++;
            }
            // If elements are the same, add any one of them and move both pointers.
            else {
                unionList.add(a[i]);
                i++;
                j++;
            }
        }

        // Add remaining elements of array a, if any.
        while (i < a.length) {
            if (unionList.isEmpty() || unionList.get(unionList.size() - 1) != a[i]) {
                unionList.add(a[i]);
            }
            i++;
        }

        // Add remaining elements of array b, if any.
        while (j < b.length) {
            if (unionList.isEmpty() || unionList.get(unionList.size() - 1) != b[j]) {
                unionList.add(b[j]);
            }
            j++;
        }

        return unionList;
    }
}

