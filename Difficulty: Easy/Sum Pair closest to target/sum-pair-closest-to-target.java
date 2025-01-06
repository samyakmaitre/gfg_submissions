//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

public class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            String line = br.readLine();
            String[] tokens = line.split(" ");

            ArrayList<Integer> array = new ArrayList<>();

            for (String token : tokens) {
                array.add(Integer.parseInt(token));
            }

            int[] arr = new int[array.size()];
            int idx = 0;
            for (int i : array) arr[idx++] = i;

            int target = Integer.parseInt(br.readLine());

            Solution ob = new Solution();
            List<Integer> res = ob.sumClosest(arr, target);
            if (res.isEmpty()) {
                System.out.print("[]");
            } else {
                for (Integer num : res) {
                    System.out.print(num + " ");
                }
            }
            System.out.println();
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public List<Integer> sumClosest(int[] arr, int target) {
        if(arr ==null || arr.length < 2){
            return new ArrayList<>();
        }
        
        Arrays.sort(arr);
        
        int closestSum = Integer.MAX_VALUE;
        int maxAbsDiff = Integer.MIN_VALUE;
        List<Integer> result = new ArrayList<>();
        
        int left = 0;
        int right = arr.length - 1;
        
        while(left < right){
            int sum = arr[left] + arr[right];
            
            if(Math.abs(target - sum) < Math.abs(target - closestSum) || 
            (Math.abs(target - sum) == Math.abs(target - closestSum) &&
            (arr[right] - arr[left] > maxAbsDiff)))
                {
                    closestSum = sum;
                    maxAbsDiff = arr[right] - arr[left];
                    result = Arrays.asList(arr[left], arr[right]);
                }
            if(sum < target){
                left++;
            }else {
                right--;
            }
        }
        return result;
    }
}