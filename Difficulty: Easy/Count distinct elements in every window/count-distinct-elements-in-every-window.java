//{ Driver Code Starts
import java.io.*;
import java.util.*;
import java.util.HashMap;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t > 0) {
            String line = br.readLine();
            String[] tokens = line.split(" ");

            ArrayList<Integer> array = new ArrayList<>();

            for (String token : tokens) {
                array.add(Integer.parseInt(token));
            }

            int[] arr = new int[array.size()];
            int idx = 0;
            for (int i : array) arr[idx++] = i;

            int k = Integer.parseInt(br.readLine());

            ArrayList<Integer> ans = new Solution().countDistinct(arr, k);

            for (Integer val : ans) System.out.print(val + " ");
            System.out.println();

            t--;
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


class Solution {
    ArrayList<Integer> countDistinct(int arr[], int k) {
        ArrayList<Integer> result = new ArrayList<>();
        HashMap<Integer, Integer> freqMap = new HashMap<>();
        int n = arr.length;
        
        for(int i=0; i<k; i++){
            freqMap.put(arr[i], freqMap.getOrDefault(arr[i], 0) + 1);
        }
        
        result.add(freqMap.size());
        
       
        for(int i = k; i<n; i++){
            
            //removing first element going out of window
            int outgoing = arr[i - k];
            if(freqMap.get(outgoing) == 1){
                freqMap.remove(outgoing);
            }else{
                freqMap.put(outgoing, freqMap.get(outgoing) - 1);
            }
            
            //add element coming into the window
            freqMap.put(arr[i], freqMap.getOrDefault(arr[i],0)+1);
            
            //add the count
            result.add(freqMap.size());
        }
        return result;
    }
}
