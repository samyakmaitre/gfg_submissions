//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) {
		Scanner scan = new Scanner(System.in);
		int test = scan.nextInt();
		
		while(test > 0){
		    String s = scan.next();
		    String t = scan.next();
		    
		    System.out.println(new Solution().smallestWindow(s, t));
		    test--;
		}
	}
}
// } Driver Code Ends


class Solution {
    public static String smallestWindow(String s, String p) {
        if (s.length() < p.length()) {
            return "-1";
        }
        
        HashMap<Character, Integer> patternMap = new HashMap<>();
        for (char ch : p.toCharArray()) {
            patternMap.put(ch, patternMap.getOrDefault(ch, 0) + 1);
        }

        int start = 0, minLength = Integer.MAX_VALUE, count = 0;
        int minStart = 0;
        
        HashMap<Character, Integer> windowMap = new HashMap<>();
        
        for (int end = 0; end < s.length(); end++) {
            char endChar = s.charAt(end);
            windowMap.put(endChar, windowMap.getOrDefault(endChar, 0) + 1);
            
            if (patternMap.containsKey(endChar) && windowMap.get(endChar) <= patternMap.get(endChar)) {
                count++;
            }
            
            while (count == p.length()) {
                if (end - start + 1 < minLength) {
                    minLength = end - start + 1;
                    minStart = start;
                }
                
                char startChar = s.charAt(start);
                windowMap.put(startChar, windowMap.get(startChar) - 1);
                
                if (patternMap.containsKey(startChar) && windowMap.get(startChar) < patternMap.get(startChar)) {
                    count--;
                }
                
                start++;
            }
        }

        if (minLength == Integer.MAX_VALUE) {
            return "-1";
        }
        
        return s.substring(minStart, minStart + minLength);
    }
}