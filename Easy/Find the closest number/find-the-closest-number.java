//{ Driver Code Starts
import java.io.*;
import java.util.*;


class IntArray
{
    public static int[] input(BufferedReader br, int n) throws IOException
    {
        String[] s = br.readLine().trim().split(" ");
        int[] a = new int[n];
        for(int i = 0; i < n; i++)
            a[i] = Integer.parseInt(s[i]);

        return a;
    }

    public static void print(int[] a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }

    public static void print(ArrayList<Integer> a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            
            int n;
            n = Integer.parseInt(br.readLine());
            
            
            int k;
            k = Integer.parseInt(br.readLine());
            
            
            int[] arr = IntArray.input(br, n);
            
            Solution obj = new Solution();
            int res = obj.findClosest(n, k, arr);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends



class Solution {
    public static int findClosest(int n, int k, int[] arr) {
        // Edge cases
        if (n == 0) return -1; // array is empty
        if (n == 1) return arr[0]; // only one element in the array
        
        // Binary search to find the closest position to `k`
        int low = 0, high = n - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] == k) {
                return arr[mid];
            } else if (arr[mid] < k) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        
        // `low` is now the index where `k` would be inserted
        int closest;
        if (low >= n) {
            // If low is out of bounds, closest is the last element
            closest = arr[n - 1];
        } else if (low == 0) {
            // If low is at the start, closest is the first element
            closest = arr[0];
        } else {
            // We are between two elements, `arr[low-1]` and `arr[low]`
            int before = arr[low - 1];
            int after = arr[low];
            
            if (Math.abs(before - k) < Math.abs(after - k)) {
                closest = before;
            } else if (Math.abs(before - k) > Math.abs(after - k)) {
                closest = after;
            } else {
                // Both distances are the same, return the greater one
                closest = Math.max(before, after);
            }
        }
        
        return closest;
    }
}      
