//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Sorting {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int g = 0; g < t; g++) {
            String[] str = (br.readLine()).trim().split(" ");
            int arr[] = new int[str.length];
            for (int i = 0; i < str.length; i++) arr[i] = Integer.parseInt(str[i]);
            System.out.println(new Solution().maxWater(arr));
            System.out.println("~");
        }
    }
}
// } Driver Code Ends




class Solution {
    public int maxWater(int arr[]) {
        // code here
        int n = arr.length;
        int leftMax = arr[0];
        Stack<Integer> rightMax = new Stack();
        rightMax.push(arr[n-1]);
        for (int i=n-2;i>=2;i--){
            int temp = Math.max(arr[i],rightMax.peek());
            rightMax.push(temp);
        }
        int total_water = 0;
        for(int i=1;i<n-1;i++){
            int watercapacity = Math.min(rightMax.peek(),leftMax);
            int tem = watercapacity-arr[i];
            int water  = Math.max(0,tem);
            total_water +=water;
            rightMax.pop();
            leftMax = Math.max(arr[i],leftMax);
        }
        return total_water;
    }
}
