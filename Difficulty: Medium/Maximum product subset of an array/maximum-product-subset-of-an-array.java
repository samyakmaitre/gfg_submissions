//{ Driver Code Starts
import java.util.*;

public class GFG {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();

        while (tc-- > 0) {
            int n = sc.nextInt();
            List<Integer> list = new ArrayList<>();

            for (int i = 0; i < n; i++) list.add(sc.nextInt());

            Solution obj = new Solution();
            long ans = obj.findMaxProduct(list);

            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


// class Solution {
//     public long findMaxProduct(List<Integer> arr) {
        
        
//         Collections.sort(arr);
//         // System.out.println(arr);
//         long prod = 1;
//         int imposter =1;
        
//         // total product except 0
//         for(int i=0; i<arr.size(); i++){
            
//             if(arr.get(i)!=0){
//                 prod *= arr.get(i);
//                     if(arr.get(i)<0){
//                     imposter = i;
//                 }
//             }
//         }
//         // if(prod<0){
//         //     prod /= arr.get(imposter);
//         // }
        
//         return prod;
//     }
// }
class Solution {
    public long findMaxProduct(List<Integer> arr) {
        long MOD = 1000000007;
        int n = arr.size();
        
        // If the list contains only one element, return it modulo MOD
        if (n == 1) {
            return arr.get(0) % MOD;
        }
        
        // Remove zeros
        List<Integer> nonZeroList = new ArrayList<>();
        for (int num : arr) {
            if (num != 0) {
                nonZeroList.add(num);
            }
        }
        
        // If all elements were zero
        if (nonZeroList.size() == 0) {
            return 0;
        }
        
        // Count negative numbers and find the minimum absolute negative number
        int negativeCount = 0;
        int minAbsNegative = Integer.MAX_VALUE;
        for (int num : nonZeroList) {
            if (num < 0) {
                negativeCount++;
                if (Math.abs(num) < minAbsNegative) {
                    minAbsNegative = Math.abs(num);
                }
            }
        }
        
        // If there is an odd number of negative numbers, remove the smallest absolute negative number
        if (negativeCount % 2 != 0) {
            nonZeroList.remove(Integer.valueOf(-minAbsNegative));
        }
        
        // Compute the product modulo MOD
        long maxProduct = 1;
        for (int num : nonZeroList) {
            maxProduct = (maxProduct * num) % MOD;
        }
        
        return maxProduct;
    }
}