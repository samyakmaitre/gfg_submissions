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

            int y;
            y = Integer.parseInt(br.readLine());

            int[] arr = IntArray.input(br, n);

            int[] brr = IntArray.input(br, n);

            Solution obj = new Solution();
            long res = obj.maxTip(n, x, y, arr, brr);

            System.out.println(res);
        }
    }
}

// } Driver Code Ends



class Solution {
    public static long maxTip(int n, int x, int y, int[] arr, int[] brr) {
        // Create a list of indices based on the difference in tips
        Integer[] indices = new Integer[n];
        for (int i = 0; i < n; i++) {
            indices[i] = i;
        }
        
        // Sort indices based on the absolute difference in tips in descending order
        Arrays.sort(indices, (i, j) -> Math.abs(arr[j] - brr[j]) - Math.abs(arr[i] - brr[i]));
        
        long totalTip = 0;
        int countA = 0;
        int countB = 0;
        
        for (int i : indices) {
            if ((arr[i] >= brr[i] && countA < x) || countB >= y) {
                // Assign order to A
                totalTip += arr[i];
                countA++;
            } else {
                // Assign order to B
                totalTip += brr[i];
                countB++;
            }
        }
        
        return totalTip;
    }
}