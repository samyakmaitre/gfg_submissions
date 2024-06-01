//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            String s;
            s = br.readLine();

            Solution obj = new Solution();
            String res = obj.oddEven(s);

            System.out.println(res);
        }
    }
}

// } Driver Code Ends



class Solution {
    public static String oddEven(String s) {
        // Step 1: Count the frequency of each character
        Map<Character, Integer> frequencyMap = new HashMap<>();
        for (char ch : s.toCharArray()) {
            frequencyMap.put(ch, frequencyMap.getOrDefault(ch, 0) + 1);
        }

        int x = 0;
        int y = 0;

        // Step 2: Iterate through the frequency map to determine counts for x and y
        for (Map.Entry<Character, Integer> entry : frequencyMap.entrySet()) {
            char ch = entry.getKey();
            int frequency = entry.getValue();
            int position = ch - 'a' + 1; // Determine the 1-based position of the character

            if (position % 2 == 0) {
                // Character is in an even position
                if (frequency % 2 == 0) {
                    x++;
                }
            } else {
                // Character is in an odd position
                if (frequency % 2 != 0) {
                    y++;
                }
            }
        }

        // Step 3: Calculate the sum and determine if it's even or odd
        int sum = x + y;
        return sum % 2 == 0 ? "EVEN" : "ODD";
    }

    // Main method for testing
    public static void main(String[] args) {
        String s1 = "abbbcc";
        System.out.println(oddEven(s1)); // Output: ODD

        String s2 = "nobitaa";
        System.out.println(oddEven(s2)); // Output: EVEN
    }
}