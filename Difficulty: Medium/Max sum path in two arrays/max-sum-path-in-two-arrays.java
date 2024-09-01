//{ Driver Code Starts
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine(); // consume the remaining newline

        for (int k = 0; k < t; k++) {
            List<Integer> arr1 = new ArrayList<>();
            String input = sc.nextLine();
            Scanner lineScanner = new Scanner(input);
            while (lineScanner.hasNextInt()) {
                arr1.add(lineScanner.nextInt());
            }
            lineScanner.close();

            List<Integer> arr2 = new ArrayList<>();
            input = sc.nextLine();
            lineScanner = new Scanner(input);
            while (lineScanner.hasNextInt()) {
                arr2.add(lineScanner.nextInt());
            }
            lineScanner.close();

            Solution ob = new Solution();
            int ans = ob.maxPathSum(arr1, arr2);
            System.out.println(ans);
        }

        sc.close();
    }
}

// } Driver Code Ends



class Solution {
    public int maxPathSum(List<Integer> arr1, List<Integer> arr2) {
    int sum1 = 0, sum2 = 0;
    int Sum = 0;

    int p1 = 0, p2 = 0;

    while (p1 < arr1.size() && p2 < arr2.size()) {

        if (arr1.get(p1) < arr2.get(p2)) {
            sum1 += arr1.get(p1++);
        } else if (arr1.get(p1) > arr2.get(p2)) {
            sum2 += arr2.get(p2++);
        } else {
            Sum += Math.max(sum1, sum2) + arr1.get(p1);
            sum1 = sum2 = 0;
            p1++;
            p2++;
        }
    }

    // Add remaining elements of arr1
    while (p1 < arr1.size()) {
        sum1 += arr1.get(p1++);
    }

    // Add remaining elements of arr2
    while (p2 < arr2.size()) {
        sum2 += arr2.get(p2++);
    }

    // Add the maximum of the remaining sums
    Sum += Math.max(sum1, sum2);

    return Sum;
}

}