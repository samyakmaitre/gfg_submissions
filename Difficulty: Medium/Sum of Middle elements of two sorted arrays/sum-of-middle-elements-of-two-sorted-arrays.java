//{ Driver Code Starts
// Initial Template for Java

import java.util.*;


// } Driver Code Ends
// User function Template for Java
class Solution {
    public int SumofMiddleElements(int[] arr1, int[] arr2) {
        ArrayList<Integer> myArr = new ArrayList<>();
        
        // Merge both arrays into myArr
        for(int i = 0; i < arr1.length; i++) {
            myArr.add(arr1[i]);
            myArr.add(arr2[i]);
        }
        
        // Sort the combined array
        Collections.sort(myArr);
        
        // Calculate the size of myArr
        int size = myArr.size();
        
        // Sum of the two middle elements
        int sum = myArr.get(size / 2) + myArr.get((size / 2) - 1);
        
        return sum;
    }
}

//{ Driver Code Starts.
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine(); // Consume newline
        while (t-- > 0) {
            String[] input1 = sc.nextLine().split(" ");
            int[] arr = new int[input1.length];
            for (int i = 0; i < input1.length; i++) {
                arr[i] = Integer.parseInt(input1[i]);
            }

            String[] input2 = sc.nextLine().split(" ");
            int[] brr = new int[input2.length];
            for (int i = 0; i < input2.length; i++) {
                brr[i] = Integer.parseInt(input2[i]);
            }

            Solution ob = new Solution();
            int res = ob.SumofMiddleElements(arr, brr);
            System.out.println(res);
        }
    }
}

// } Driver Code Ends