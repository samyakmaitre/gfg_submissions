//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

public class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);

        int t = Integer.parseInt(in.readLine().trim());
        while (t-- > 0) {
            String line = in.readLine();
            String[] tokens = line.split(" ");

            // Create an ArrayList to store the integers
            ArrayList<Integer> array = new ArrayList<>();

            // Parse the tokens into integers and add to the array
            for (String token : tokens) {
                array.add(Integer.parseInt(token));
            }

            int[] arr = new int[array.size()];
            int idx = 0;
            for (int i : array) arr[idx++] = i;

            int key = Integer.parseInt(in.readLine().trim());

            out.println(new Solution().threeSumClosest(arr, key));
        }
        out.close();
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    static int threeSumClosest(int[] array, int target) {
        //sort the array
        Arrays.sort(array);
        int closestSum = Integer.MAX_VALUE ;
        //iterate through the array
        for(int i=0; i<array.length-2;i++){
            int left = i+1;
            int right = array.length - 1;
            //use two pointers to find the best pair
            while (left<right){
                int currentSum = array[i] + array[left] +array[right];
                //update the closest sum if the current sum i scloser to the target
                if(Math.abs(target-currentSum)<Math.abs(target - closestSum)){
                    closestSum = currentSum;
                } else if (Math.abs(target - currentSum) == Math.abs(target - closestSum)) {
                    //if the difference is the same, take the maximum sum
                    closestSum = Math.max(closestSum, currentSum);
                }
                //move pointers
                if(currentSum < target){
                    left++;
                } else {
                    right--;
                }
            }
        }
        return closestSum;
    }
}
