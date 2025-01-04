//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        while (t-- > 0) {
            String[] arr1Str = sc.nextLine().split(" ");
            int[] arr = Arrays.stream(arr1Str).mapToInt(Integer::parseInt).toArray();
            int target = Integer.parseInt(sc.nextLine());

            Solution ob = new Solution();
            int ans = ob.countTriplets(arr, target);
            System.out.println(ans);
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


class Solution {
    public int countTriplets(int[] arr, int target) {
         int n = arr.length;
        int count = 0;

        // Sort the array
        Arrays.sort(arr);

        // Traverse each element as the fixed one
        for (int i = 0; i < n - 2; i++) {
            int left = i + 1;
            int right = n - 1;

            // Use two pointers to find the other two elements
            while (left < right) {
                int currentSum = arr[i] + arr[left] + arr[right];

                if (currentSum == target) {
                    // Count all occurrences of this triplet
                    if (arr[left] == arr[right]) {
                        // If `left` and `right` point to the same value, all combinations are valid
                        int numElements = right - left + 1;
                        count += numElements * (numElements - 1) / 2;
                        break;
                    } else {
                        // Count duplicates separately
                        int leftCount = 1, rightCount = 1;
                        while (left + 1 < right && arr[left] == arr[left + 1]) {
                            left++;
                            leftCount++;
                        }
                        while (right - 1 > left && arr[right] == arr[right - 1]) {
                            right--;
                            rightCount++;
                        }
                        count += leftCount * rightCount;
                        left++;
                        right--;
                    }
                } else if (currentSum < target) {
                    left++;
                } else {
                    right--;
                }
            }
        }

        return count;
    }
}
    

